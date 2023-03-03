package com.example.composetodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import com.example.composetodoapp.navigation.SetupNavigation
import com.example.composetodoapp.ui.theme.ComposeToDoAppTheme
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToDoAppTheme {
                navController = rememberAnimatedNavController()
                SetupNavigation(navController = navController, mainViewModel = mainViewModel)
            }
        }
    }
}