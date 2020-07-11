package com.example.hq

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
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




        FirebaseAuth.getInstance().createUserWithEmailAndPassword(intent.getStringExtra("Email"), intent.getStringExtra("Password"))
            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener

                Toast.makeText(this, "Account created! Proceed to login", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this, "There seems to be a problem... Try again later", Toast.LENGTH_LONG).show()
            }




        var mRootRef = FirebaseDatabase.getInstance().getReference() as DatabaseReference






    }
}
