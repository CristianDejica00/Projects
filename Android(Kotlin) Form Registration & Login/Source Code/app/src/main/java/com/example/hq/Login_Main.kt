package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login__main.*

class Login_Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login__main)


        button4.setOnClickListener {
            val intent = Intent(this, RegisterMain::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {

            val first_input = findViewById(R.id.editText) as TextView
            val second_input = findViewById(R.id.editText2) as TextView
            val first_input_value = first_input.text
            val second_input_value = second_input.text

            val alertDialogBuilder = AlertDialog.Builder(this)
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

            if(first_input_value.trim().length ==  0) {
                alertDialog.setMessage("You must enter your email address")
                alertDialog.show()
            } else if(!checkIfEmailValid(first_input_value.toString())) {
                alertDialog.setMessage("You must enter a valid email")
                alertDialog.show()
            } else if(second_input_value.trim().length < 8) {
                alertDialog.setMessage("Your password must be at least 8 characters long")
                alertDialog.show()
            } else {
                val first_value = first_input.text as String
                val second_value = second_input.text as String
                FirebaseAuth.getInstance().signInWithEmailAndPassword(first_value, second_value)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener

                    val intent = Intent(this, MainFeed::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Wrong email and password", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
