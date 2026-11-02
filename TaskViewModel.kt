package com.example.studentstudyplandermaskmanger

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = TaskRepository(application)
    private val _allTasks = MutableLiveData<List<TaskEntity>>()
    val allTasks: LiveData<List<TaskEntity>> get() = _allTasks

    init {
        loadTasks()
    }

    fun loadTasks() {
        _allTasks.value = repository.getAllTasks()
    }

    fun insert(title: String, subject: String, priority: String) {
        repository.insert(title, subject, priority)
        loadTasks()
    }
}