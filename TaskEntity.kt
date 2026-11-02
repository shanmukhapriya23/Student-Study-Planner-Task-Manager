package com.example.studentstudyplandermaskmanger

data class TaskEntity(
    val id: Int = 0,
    val title: String,
    val subject: String = "",
    val priority: String = "Medium",
    val isCompleted: Boolean = false
)