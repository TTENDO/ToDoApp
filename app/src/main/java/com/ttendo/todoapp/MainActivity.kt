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
        val countryList = listOf("Uganda", "Kenya", "Tanzania", "Rwanda", "Burundi",
            "DRC", "UK", "South Sudan", "USA", "Canada")
        val cityList = listOf("Kampala", "Nairobi", "Dar e Salam", "Kigali", "Burundi",
            "DRC", "UK", "South Sudan", "USA", "Canada")
        //val arrayAdapter = ArrayAdapter(this,R.layout.new_list_layout,R.id.sampleTextView,countryList)
        val arrayAdapter = NewAdapter(this,countryList,cityList)
        myList.adapter = arrayAdapter
    }
}

class NewAdapter(context: Context, val countryList: List<String>, val cityList:List<String>): ArrayAdapter<String>(context,R.layout.new_list_layout,R.id.sampleTextView,countryList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        val view = super.getView(position, convertView, parent)

        val countryId = view.findViewById<TextView>(R.id.sampleTextView)
        val cityId = view.findViewById<TextView>(R.id.capital)
        countryId.text = countryList[position]
        cityId.text = cityList[position]

        return view
    }
}