package com.example.composetodoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composetodoapp.ui.screens.splash.SplashScreen
import com.example.composetodoapp.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(navigateToListScreen: () -> Unit) {
    composable(route = SPLASH_SCREEN) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}