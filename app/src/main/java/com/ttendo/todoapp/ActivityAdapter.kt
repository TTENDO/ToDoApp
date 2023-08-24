package com.ttendo.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ActivityAdapter(var context:Context,var list:ArrayList<ActivityModel>):RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>(){
    class ActivityViewHolder(itemView: View):ViewHolder(itemView){
        //get elements from the custom layout view
        val image = itemView.findViewById<ImageView>(R.id.icon)
        val name = itemView.findViewById<TextView>(R.id.activity_name)
        val time = itemView.findViewById<TextView>(R.id.activity_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view_layout,null,false)
        return  ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.image.setImageResource(list[position].image)
        holder.time.text = list[position].activityTime
        holder.name.text = list[position].activityName
    }
}