package com.example.composetodoapp.ui.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.composetodoapp.R
import com.example.composetodoapp.ui.theme.fabBackgroundColor
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.SearchAppBarState

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    mainViewModel: MainViewModel
) {
    val searchAppBarState: SearchAppBarState by mainViewModel.searchAppBarState
    val searchTextState: String by mainViewModel.searchTextState

    Scaffold(topBar = {
        ListAppBar(
            mainViewModel = mainViewModel,
            searchAppBarState = searchAppBarState,
            searchTextState = searchTextState
        )
    },
        content = { ListContent() },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        })
}

@Composable
fun ListFab(onFabClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = { onFabClicked(-1) },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}