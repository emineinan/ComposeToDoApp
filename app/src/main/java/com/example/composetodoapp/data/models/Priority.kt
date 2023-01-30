package com.example.composetodoapp.data.models

import androidx.compose.ui.graphics.Color
import com.example.composetodoapp.ui.theme.HighPriorityColor
import com.example.composetodoapp.ui.theme.LowPriorityColor
import com.example.composetodoapp.ui.theme.MediumPriorityColor
import com.example.composetodoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}