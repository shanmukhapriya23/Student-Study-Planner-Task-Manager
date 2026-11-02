package com.example.studentstudyplandermaskmanger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private var taskList: List<TaskEntity>) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.tvTitle.text = task.title
        holder.tvSubject.text = task.subject
        holder.tvPriority.text = task.priority
        holder.checkBox.isChecked = task.isCompleted
    }

    override fun getItemCount(): Int = taskList.size

    fun updateTasks(newTasks: List<TaskEntity>) {
        taskList = newTasks
        notifyDataSetChanged()
    }
}