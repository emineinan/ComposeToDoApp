package com.example.composetodoapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composetodoapp.navigation.destinations.listComposable
import com.example.composetodoapp.navigation.destinations.taskComposable
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen = screen.task, mainViewModel = mainViewModel)
        taskComposable(navigateToListScreen = screen.list, mainViewModel = mainViewModel)
    }
}