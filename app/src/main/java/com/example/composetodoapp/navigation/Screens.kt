package com.example.composetodoapp.navigation

import androidx.navigation.NavHostController
import com.example.composetodoapp.util.Action
import com.example.composetodoapp.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = {
        navController.navigate(route = "list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = {
        navController.navigate(route = "task/$it")
    }
}