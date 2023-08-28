package com.ttendo.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ttendo.todoapp.data.ActivityAdapter
import com.ttendo.todoapp.data.ActivityModel
import com.ttendo.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<ActivityModel>()

        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Give thanks","unknown"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))
        list.add(ActivityModel(R.drawable.ic_android_black_24dp,"Check the time","5:10am"))

        val adapter = ActivityAdapter(this,list)
        val recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

