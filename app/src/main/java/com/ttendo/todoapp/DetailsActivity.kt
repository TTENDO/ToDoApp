package com.ttendo.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

//        val image = intent.getIntExtra("image",R.drawable.phone)
//        val name= intent.getStringExtra("activityName")
//        val icon = findViewById<ImageView>(R.id.icon)
//        icon.setImageResource(image)


        val image = intent.getIntExtra("image", R.drawable.phone)
        val name = intent.getStringExtra("activityName")
        val status = intent.getSerializableExtra("activityStatus")
        Log.d("Status", "$status")

        val icon = findViewById<ImageView>(R.id.activity_icon)
        icon.setImageResource(image)

        val button = findViewById<Button>(R.id.status_button)
        button.text = status.toString()
    }
}