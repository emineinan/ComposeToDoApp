package com.example.composetodoapp.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (mainViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context = context)
                        }
                    }
                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = { mainViewModel.updateTitle(it) },
                description = description,
                onDescriptionChange = { mainViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { mainViewModel.priority.value = it }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty.", Toast.LENGTH_SHORT).show()
}