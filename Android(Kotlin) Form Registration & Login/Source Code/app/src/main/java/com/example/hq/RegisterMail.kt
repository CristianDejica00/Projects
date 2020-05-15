package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register_mail.*

class RegisterMail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_mail)

        button14.setOnClickListener {
            val intent = Intent(this, Login_Main::class.java)
            startActivity(intent)
        }

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

        alertDialog.setMessage(
            "Name: " + intent.getStringExtra("Name") + '\n' +
                    "Email: " + intent.getStringExtra("Email") + '\n' +
                    "Password: " + intent.getStringExtra("Password") + '\n' +
                    "Gender: " + intent.getStringExtra("Gender") + '\n' +
                    "Birthdate: " + intent.getStringExtra("Birthdate")
        )
        alertDialog.show()


    }
}
