package com.example.composetodoapp.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.composetodoapp.data.models.Priority
import com.example.composetodoapp.data.models.ToDoTask
import com.example.composetodoapp.ui.viewmodels.MainViewModel
import com.example.composetodoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    mainViewModel: MainViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by mainViewModel.title
    val description: String by mainViewModel.description
    val priority: Priority by mainViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { mainViewModel.title.value = it },
                description = description,
                onDescriptionChange = { mainViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { mainViewModel.priority.value = it }
            )
        }
    )
}