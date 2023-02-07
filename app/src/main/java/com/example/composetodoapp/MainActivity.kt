package com.example.composetodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetodoapp.navigation.SetupNavigation
import com.example.composetodoapp.ui.theme.ComposeToDoAppTheme
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToDoAppTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController, mainViewModel = mainViewModel)
            }
        }
    }
}