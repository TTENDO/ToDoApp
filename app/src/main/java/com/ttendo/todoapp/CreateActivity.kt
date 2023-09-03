package com.ttendo.todoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.icu.text.SimpleDateFormat
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.ttendo.todoapp.databinding.ActivityCreateBinding
import com.ttendo.todoapp.databinding.ActivityMainBinding
import java.net.URI
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.jar.Manifest


class CreateActivity : AppCompatActivity() {
    val CAMERA_PERMISSION_CODE = 1
    val GALLERY_PERMISSION_CODE = 2
    lateinit var binding: ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_create)
        //setContentView(R.layout.new_activity_create)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_camera = binding.fromCameraBtn
        btn_camera.setOnClickListener() {
            checkPermission(android.Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE)
        }

        val fileCapture = binding.fromGalleryBtn
        fileCapture.setOnClickListener() {
            checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE,GALLERY_PERMISSION_CODE)
        }

        val activityName = binding.name.text.toString()
        val activityDescription = binding.description.text.toString()


        val myDatePicker = binding.date
        val myDatePickerBtn = binding.newDateBtn

        myDatePickerBtn.setOnClickListener {
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

            datePickerDialog.show()
        }

        val myTimePickerBtn = binding.timeBtn
        val time = binding.time

        myTimePickerBtn.setOnClickListener{
            // Get Current Time
            // Get Current Time
            val c = Calendar.getInstance()
            val mHour = c[Calendar.HOUR_OF_DAY]
            val mMinute = c[Calendar.MINUTE]

            // Launch Time Picker Dialog

            // Launch Time Picker Dialog
            val timePickerDialog = TimePickerDialog(this,
                { view, hourOfDay, minute ->
                    binding.time.text = "$hourOfDay:$minute"
                },
                mHour,
                mMinute,
                false
            )
            timePickerDialog.show()
        }

    }
    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, CAMERA_PERMISSION_CODE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }
    private fun dispatchGetPicFromGalleryIntent() {
            val galleryPictureIntent = Intent(MediaStore.ACTION_PICK_IMAGES)

        try {
            startActivityForResult(galleryPictureIntent, GALLERY_PERMISSION_CODE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                dispatchTakePictureIntent()
            }
            else{
                Toast.makeText(this,"Camera Permission Denied",Toast.LENGTH_SHORT).show()
            }
        }
        else if(requestCode == GALLERY_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                dispatchGetPicFromGalleryIntent()
            }
            else{
                Toast.makeText(this,"File Permission Denied",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_PERMISSION_CODE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.showCameraImage.setImageBitmap(imageBitmap)
        }
        else if(requestCode == GALLERY_PERMISSION_CODE && resultCode == RESULT_OK){
//            val imageBitmap = data?.extras?.get("data") as Uri
            val imageBitmap = data?.data
            binding.showImage.setImageURI(imageBitmap)
        }
    }

    //function to check and request for permissions
    private  fun checkPermission(permission: String, requestCode: Int) {
        if(ContextCompat.checkSelfPermission(this@CreateActivity,permission) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this@CreateActivity,arrayOf(permission),requestCode)
        }else{
            if(requestCode == CAMERA_PERMISSION_CODE){
                dispatchTakePictureIntent()
            }
            else if(requestCode == GALLERY_PERMISSION_CODE){
                dispatchGetPicFromGalleryIntent()
            }
        }
    }
}