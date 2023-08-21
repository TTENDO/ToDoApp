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

        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ivan Ojok","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Mugabi Daniel","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ttendo Becky","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ivan Ojok","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Mugabi Daniel","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ttendo Becky","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ivan Ojok","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Mugabi Daniel","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ttendo Becky","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ivan Ojok","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Mugabi Daniel","Hello, how are you doing?","Yesterday"))
        list.add(ChatModel(R.drawable.ic_android_black_24dp,"Ttendo Becky","Hello, how are you doing?","Yesterday"))

        val baseAdapter = MyAdapter(this,list)

        binding.myList.adapter = baseAdapter
    }
}

