package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register_gender.*

class RegisterGender : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var clicked: Boolean? = false
        var gender = ""

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_gender)



        button9.setOnClickListener {
            button9.setBackgroundResource(R.drawable.gender_male_active)
            button10.setBackgroundResource(R.drawable.gender_female_inactive)
            clicked = true
            gender = "male"
        }
        button10.setOnClickListener {
            button9.setBackgroundResource(R.drawable.gender_male_inactive)
            button10.setBackgroundResource(R.drawable.gender_female_active)
            clicked = true
            gender = "female"
        }

        button7.setOnClickListener {
            val intent = Intent(this, Login_Main::class.java)
            startActivity(intent)
        }

        button8.setOnClickListener {

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


            if(!clicked!!) {
                alertDialog.setMessage("You must select your gender")
                alertDialog.show()
            } else {
                val pastName = intent.getStringExtra("Name")
                val pastUsername = intent.getStringExtra("Username")
                val pastEmail = intent.getStringExtra("Email")
                val pastPassword = intent.getStringExtra("Password")
                intent = Intent(this, RegisterAge::class.java)
                intent.putExtra("Name", pastName)
                intent.putExtra("Username", pastUsername)
                intent.putExtra("Email", pastEmail)
                intent.putExtra("Password", pastPassword)
                intent.putExtra("Gender", gender)
                startActivity(intent)
            }


        }


    }
}
