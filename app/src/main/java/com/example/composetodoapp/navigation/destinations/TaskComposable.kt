package com.example.composetodoapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.navArgument
import com.example.composetodoapp.ui.screens.task.TaskScreen
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.Action
import com.example.composetodoapp.util.Constants.TASK_ARGUMENT_KEY
import com.example.composetodoapp.util.Constants.TASK_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.taskComposable(
    mainViewModel: MainViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
        enterTransition = { _, _ ->
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(
                    durationMillis = 300
                )
            )
        }
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId) {
            mainViewModel.getSelectedTask(taskId = taskId)
        }

        val selectedTask by mainViewModel.selectedTask.collectAsState()
        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                mainViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            mainViewModel = mainViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}