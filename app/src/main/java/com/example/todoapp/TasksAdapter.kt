package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.database.Task

class TasksAdapter(var tasks : List<Task>):RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    class TasksViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val title: TextView= itemView.findViewById(R.id.item_task_title)
         val isCompleted:CheckBox= itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
       val task= tasks[position]
        holder.apply {
            title.text= task.title
            isCompleted.isChecked= task.isCompleted?:false
        }
    }

    override fun getItemCount()= tasks.size
    fun setData(tasks:List<Task>){
        this.tasks=tasks
        notifyDataSetChanged()
    }
}