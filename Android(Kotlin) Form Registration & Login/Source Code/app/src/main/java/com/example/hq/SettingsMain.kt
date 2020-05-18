package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings_main.*

class SettingsMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_main)
        button37.background.setAlpha(70);
        button38.background.setAlpha(70);
        button39.background.setAlpha(255);
        button40.background.setAlpha(70);


        button37.setOnClickListener {
            val intent = Intent(this, MainFeed::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }
        button38.setOnClickListener {
            val intent = Intent(this, CreateQuest::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }
        button40.setOnClickListener {
            val intent = Intent(this, ProfileMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }



    }
}
