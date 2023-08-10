package com.ttendo.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ttendo.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myList = binding.myList
        val countryList = listOf("Uganda","Kenya","Britain","Rwanda","USA","Canada","Jamaica","UK","France","Poland")

        val arrayAdapter = ArrayAdapter(this,R.layout.new_list_layout,R.id.sampleTextView,countryList)

        myList.adapter = arrayAdapter
    }
}