package com.example.studentstudyplandermaskmanger

import android.content.Context

class TaskRepository(context: Context) {
    private val taskDao = TaskDao(context)

    fun insert(title: String, subject: String, priority: String) {
        taskDao.insertTask(title, subject, priority)
    }

    fun getAllTasks(): List<TaskEntity> {
        return taskDao.getAllTasks()
    }
}