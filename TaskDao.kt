package com.example.studentstudyplandermaskmanger

import android.content.Context

class TaskDao(context: Context) {
    private val dbHelper = TaskDbHelper(context)

    fun insertTask(title: String, subject: String, priority: String) {
        dbHelper.insertTask(title, subject, priority)
    }

    fun getAllTasks(): List<TaskEntity> {
        return dbHelper.getAllTasks()
    }
}