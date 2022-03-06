package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addBtn.setOnClickListener{
            goToAddTaskActivity()
        }


    }

    private fun goToAddTaskActivity() {
        val intent= Intent(this,AddTaskActivity::class.java)
        startActivity(intent)
        finish()
    }
}