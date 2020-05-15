package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register_main.*

class RegisterMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_main)

        button5.setOnClickListener {
            val intent = Intent(this, Login_Main::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener {


            val name_input = findViewById(R.id.editText3) as TextView
            val email_input = findViewById(R.id.editText4) as TextView
            val password_input = findViewById(R.id.editText5) as TextView
            val confirm_password_input = findViewById(R.id.editText6) as TextView
            val name_input_value = name_input.text
            val email_input_value = email_input.text
            val password_input_value = password_input.text
            val confirm_password_input_value = confirm_password_input.text

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

            fun checkIfEmailValid(str: String) : Boolean {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
            }


            if(name_input_value.trim().length ==  0) {
                alertDialog.setMessage("You must enter your name")
                alertDialog.show()
            } else if(email_input_value.trim().length < 8) {
                alertDialog.setMessage("You must enter your email address")
                alertDialog.show()
            } else if(!checkIfEmailValid(email_input_value.toString())) {
                alertDialog.setMessage("You must enter a valid email")
                alertDialog.show()
            } else if(password_input_value.trim().length < 8) {
                alertDialog.setMessage("Your password must be at least 8 characters long")
                alertDialog.show()
            } else if(password_input_value.toString() != confirm_password_input_value.toString()) {
                alertDialog.setMessage("Your passwords must match")
                alertDialog.show()
            } else {
                val intent = Intent(this, RegisterGender::class.java)

                val name_input_value = name_input.text
                val email_input_value = email_input.text
                val password_input_value = password_input.text

                intent.putExtra("Name", name_input_value.toString())
                intent.putExtra("Email", email_input_value.toString())
                intent.putExtra("Password", password_input_value.toString())
                startActivity(intent)
            }


        }
    }
}
