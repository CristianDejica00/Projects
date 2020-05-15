package com.example.hq

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register_age.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class RegisterAge : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_age)


        val alertDialogBuilder =
            AlertDialog.Builder(this)
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        val window: Window? = alertDialog.getWindow()
        val wlp = window?.attributes
        if (wlp != null) {
            wlp.gravity = Gravity.BOTTOM
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = wlp
            wlp.y = 100
        }

        var dateToInput = ""
        var d = ""
        var m = ""
        var y = ""

        button13.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    d = dayOfMonth.toString()
                    m = (monthOfYear + 1).toString()
                    y = year.toString()
                    if (dayOfMonth < 10) {
                        d = "0" + d
                    }
                    if (monthOfYear < 10) {
                        m = "0" + m
                    }
                    dateToInput = d + " / " + m + " / " + y

                    button13.setText(dateToInput)

                },
                2000,
                0,
                1
            )
            datePickerDialog.show()
        }

        button11.setOnClickListener {
            val intent = Intent(this, Login_Main::class.java)
            startActivity(intent)
        }

        button12.setOnClickListener {

            if(dateToInput == "") {
                alertDialog.setMessage("You must select you birth date")
                alertDialog.show()
            } else  {
                val dateS = y+"-"+m+"-"+d
                val selectedDate = LocalDate.parse(dateS, DateTimeFormatter.ISO_DATE)
                val currentDate = LocalDateTime.now()
                val diff = selectedDate.until(currentDate, ChronoUnit.YEARS)
                if(diff < 18) {
                    alertDialog.setMessage("You must be 18 years or older")
                    alertDialog.show()
                } else {
                    val pastName = intent.getStringExtra("Name")
                    val pastUsername = intent.getStringExtra("Username")
                    val pastEmail = intent.getStringExtra("Email")
                    val pastPassword = intent.getStringExtra("Password")
                    val gender = intent.getStringExtra("Gender")
                    val bod = dateS
                    intent = Intent(this, RegisterMail::class.java)
                    intent.putExtra("Name", pastName)
                    intent.putExtra("Username", pastUsername)
                    intent.putExtra("Email", pastEmail)
                    intent.putExtra("Password", pastPassword)
                    intent.putExtra("Gender", gender)
                    intent.putExtra("Birthdate", bod)
                    startActivity(intent)
                }
            }

        }
    }
}
