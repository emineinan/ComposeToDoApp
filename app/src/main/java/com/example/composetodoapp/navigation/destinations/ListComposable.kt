package com.example.composetodoapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.composetodoapp.ui.screens.list.ListScreen
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.composetodoapp.util.Constants.LIST_SCREEN
import com.example.composetodoapp.util.toAction

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    mainViewModel: MainViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            mainViewModel.action.value = action
        }

        ListScreen(navigateToTaskScreen = navigateToTaskScreen, mainViewModel = mainViewModel)
    }
}