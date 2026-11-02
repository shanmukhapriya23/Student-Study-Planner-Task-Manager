package com.example.studentstudyplandermaskmanger

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    val tvSubject: TextView = itemView.findViewById(R.id.tvSubject)
    val tvPriority: TextView = itemView.findViewById(R.id.tvPriority)
    val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
}