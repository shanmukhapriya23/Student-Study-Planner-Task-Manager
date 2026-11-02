package com.example.studentstudyplandermaskmanger

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val taskViewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var etTaskTitle: TextInputEditText
    private lateinit var etTaskSubject: TextInputEditText
    private lateinit var spinnerPriority: AutoCompleteTextView
    private lateinit var btnAddTask: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTaskCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTaskTitle = findViewById(R.id.etTaskTitle)
        etTaskSubject = findViewById(R.id.etTaskSubject)
        spinnerPriority = findViewById(R.id.spinnerPriority)
        btnAddTask = findViewById(R.id.btnAddTask)
        recyclerView = findViewById(R.id.recyclerView)
        tvTaskCount = findViewById(R.id.tvTaskCount)

        // Setup Priority Dropdown Spinner
        val priorities = listOf("High", "Medium", "Low")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, priorities)
        spinnerPriority.setAdapter(adapter)
        spinnerPriority.setText("Medium", false)

        // Setup RecyclerView
        taskAdapter = TaskAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        // Observe LiveData
        taskViewModel.allTasks.observe(this) { tasks ->
            taskAdapter.updateTasks(tasks)
            tvTaskCount.text = "${tasks.size} tasks remaining"
        }

        // Add Task Button Click
        btnAddTask.setOnClickListener {
            val title = etTaskTitle.text.toString().trim()
            val subject = etTaskSubject.text.toString().trim()
            val priority = spinnerPriority.text.toString()

            if (title.isNotEmpty()) {
                taskViewModel.insert(title, subject, priority)
                etTaskTitle.text?.clear()
                etTaskSubject.text?.clear()
                Toast.makeText(this, "Task added successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a task title", Toast.LENGTH_SHORT).show()
            }
        }
    }
}