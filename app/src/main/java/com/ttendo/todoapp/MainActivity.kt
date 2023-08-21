package com.ttendo.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.ttendo.todoapp.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myList = binding.myList
        val list = ArrayList<ChatModel>()

        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Galaxy F04","UGX 375,000",1))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Galaxy M04","UGX 465,000",1))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Galaxy AO3s","UGX 410,000",1))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Galaxy A14","UGX 468,000",1))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Note 10","UGX 1,375,000",1))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Samsung Galaxy AO3 Core","UGX 349,000",1))


        val baseAdapter = MyAdapter(this,list)

        binding.myList.adapter = baseAdapter
    }
}

