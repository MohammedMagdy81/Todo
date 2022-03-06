package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.database.TaskDatabase
import com.example.todoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var adapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener{
            goToAddTaskActivity()
        }
        initRecyclerView()

    }

    override fun onStart() {
        super.onStart()
        val tasks= TaskDatabase.getInstance(applicationContext).TasksDao().getAllTasks()
        adapter.setData(tasks)
    }

    private fun initRecyclerView() {
        adapter= TasksAdapter(listOf())
        binding.recyclerView.adapter=adapter
    }

    private fun goToAddTaskActivity() {
        val intent= Intent(this,AddTaskActivity::class.java)
        startActivity(intent)

    }
}