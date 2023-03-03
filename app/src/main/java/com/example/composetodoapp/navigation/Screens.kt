package com.example.composetodoapp.navigation

import androidx.navigation.NavHostController
import com.example.composetodoapp.util.Action
import com.example.composetodoapp.util.Constants.LIST_SCREEN
import com.example.composetodoapp.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (Int) -> Unit = {
        navController.navigate(route = "task/$it")
    }

    val task: (Action) -> Unit = {
        navController.navigate(route = "list/${it}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}