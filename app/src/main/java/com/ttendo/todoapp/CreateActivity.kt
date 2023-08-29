package com.ttendo.todoapp

import android.app.DatePickerDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.ttendo.todoapp.databinding.ActivityCreateBinding
import com.ttendo.todoapp.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.Date
import java.util.Locale


class CreateActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        //setContentView(R.layout.new_activity_create)

        val btn_camera = findViewById<Button>(R.id.camera_btn)
        btn_camera.setOnClickListener() {
            dispatchTakePictureIntent()
        }

        val myDatePicker = findViewById<TextView>(R.id.date)
        val myDatePickerBtn = findViewById<ImageView>(R.id.new_date_btn)

        var selectedDate = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                selectedDate.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)
                myDatePicker.text = formattedDate
            },
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        myDatePickerBtn.setOnClickListener {
            datePickerDialog.show()
        }
//        myDatePicker.setOnClickListener() {
//            // Initiation date picker with
//            // MaterialDatePicker.Builder.datePicker()
//            // and building it using build()
//            val datePicker = MaterialDatePicker.Builder.datePicker().build()
//            datePicker.show(supportFragmentManager, "DatePicker")
//
//            // Setting up the event for when ok is clicked
//            datePicker.addOnPositiveButtonClickListener {
//                // formatting date in dd-mm-yyyy format.
//                val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
//                val date = dateFormatter.format(Date(it))
//                Toast.makeText(this, "$date is selected", Toast.LENGTH_LONG).show()
//            }
//
//            //myDatePicker.text = date.setText
//
//            // Setting up the event for when cancelled is clicked
//            datePicker.addOnNegativeButtonClickListener {
//                Toast.makeText(this, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG)
//                    .show()
//            }
//
//            // Setting up the event for when back button is pressed
//            datePicker.addOnCancelListener {
//                Toast.makeText(this, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
//            }
//
//
//        }
    }
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val showImage = findViewById<ImageView>(R.id.show_image)
            showImage.setImageBitmap(imageBitmap)
        }
    }
}