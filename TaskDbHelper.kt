package com.example.studentstudyplandermaskmanger

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TaskDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "study_tasks.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_TASKS = "tasks"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_SUBJECT = "subject"
        const val COLUMN_PRIORITY = "priority"
        const val COLUMN_COMPLETED = "is_completed"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_TASKS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_TITLE TEXT, " +
                "$COLUMN_SUBJECT TEXT, " +
                "$COLUMN_PRIORITY TEXT, " +
                "$COLUMN_COMPLETED INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TASKS")
        onCreate(db)
    }

    fun insertTask(title: String, subject: String, priority: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, title)
            put(COLUMN_SUBJECT, subject)
            put(COLUMN_PRIORITY, priority)
            put(COLUMN_COMPLETED, 0)
        }
        return db.insert(TABLE_TASKS, null, values)
    }

    fun getAllTasks(): List<TaskEntity> {
        val taskList = mutableListOf<TaskEntity>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_TASKS", null)
        if (cursor.moveToFirst()) {
            do {
                val idIdx = cursor.getColumnIndex(COLUMN_ID)
                val titleIdx = cursor.getColumnIndex(COLUMN_TITLE)
                val subjectIdx = cursor.getColumnIndex(COLUMN_SUBJECT)
                val priorityIdx = cursor.getColumnIndex(COLUMN_PRIORITY)
                val completedIdx = cursor.getColumnIndex(COLUMN_COMPLETED)

                if (titleIdx != -1) {
                    taskList.add(
                        TaskEntity(
                            id = if (idIdx != -1) cursor.getInt(idIdx) else 0,
                            title = cursor.getString(titleIdx),
                            subject = if (subjectIdx != -1) cursor.getString(subjectIdx) else "",
                            priority = if (priorityIdx != -1) cursor.getString(priorityIdx) else "Medium",
                            isCompleted = if (completedIdx != -1) cursor.getInt(completedIdx) == 1 else false
                        )
                    )
                }
            } while (cursor.moveToNext())
        }
        cursor.close()
        return taskList
    }
}