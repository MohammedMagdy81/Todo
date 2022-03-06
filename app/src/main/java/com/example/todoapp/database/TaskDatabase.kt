package com.example.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class],version = 1,exportSchema = false)
abstract class TaskDatabase :RoomDatabase(){

    abstract fun TasksDao():TaskDao

    companion object{
         private var database:TaskDatabase?=null
         private val DATA_BASE_NAME="tasks-db"

        fun getInstance(context: Context):TaskDatabase{
            if (database== null){
                database= Room.databaseBuilder(context,TaskDatabase::class.java, DATA_BASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }
}