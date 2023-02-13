package com.example.composetodoapp.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composetodoapp.ui.screens.task.TaskScreen
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.Action
import com.example.composetodoapp.util.Constants.TASK_ARGUMENT_KEY
import com.example.composetodoapp.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    mainViewModel: MainViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        mainViewModel.getSelectedTask(taskId = taskId)
        val selectedTask by mainViewModel.selectedTask.collectAsState()
        TaskScreen(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen)
    }
}