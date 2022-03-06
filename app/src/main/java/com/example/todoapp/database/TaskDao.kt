package com.example.todoapp.database

import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun addTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("select * from task")
    fun getAllTasks():List<Task>

    @Query("select* from task where title like :word or description like :word ")
    fun searchForTask(word:String):List<Task>
}