package com.example.todoapp

import android.content.DialogInterface
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.todoapp.base.BaseActivity
import com.example.todoapp.database.Task
import com.example.todoapp.database.TaskDatabase
import com.example.todoapp.databinding.ActivityAddTaskBinding

class AddTaskActivity : BaseActivity() {
    lateinit var binding : ActivityAddTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
        binding.saveBtn.setOnClickListener{
            addTask()
        }

    }

    private fun setUpViews() {
        binding.txtInputTitle.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.txtInputTitle.error=null
            }

        })
        binding.txtInputDescription.editText?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.txtInputDescription.error=null
            }

        })

    }

    private fun addTask() {
        if (!valid()) return
        val title = binding.txtInputTitle.editText?.text.toString()
        val desc = binding.txtInputDescription.editText?.text.toString()
        val isCompleted= binding.completed.isChecked
        val task= Task(title = title,description = desc,isCompleted = isCompleted)
        TaskDatabase.getInstance(applicationContext).TasksDao().addTask(task)
        showDialog(message = "Task Added Successfully ", posActionName = "Ok ", posAction = { dialogInterface, i ->
            dialogInterface.dismiss()
            finish()
        })
    }

    private fun valid(): Boolean {
        var isValid =true
        if (binding.txtInputTitle.editText?.text.toString().isBlank()){
            isValid=false
            binding.txtInputTitle.error="Please Enter Title !"
        }
        if (binding.txtInputDescription.editText?.text.toString().isBlank()){
            isValid=false
            binding.txtInputDescription.error="Please Enter Description !"
        }
            return isValid
    }
}