package com.example.hq

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import kotlinx.android.synthetic.main.activity_login__main.*
import kotlinx.android.synthetic.main.activity_profile_main.*


class ProfileMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_main)

        button36.background.setAlpha(255);
        button33.background.setAlpha(70);
        button34.background.setAlpha(70);
        button35.background.setAlpha(70);


        button33.setOnClickListener {
            val intent = Intent(this, MainFeed::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }
        button34.setOnClickListener {
            val intent = Intent(this, CreateQuest::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }
        button35.setOnClickListener {
            val intent = Intent(this, SettingsMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }



        nestedScrollView.setOnScrollChangeListener {
                v: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int ->
            if(oldScrollY < scrollY) {
                val params: ViewGroup.LayoutParams = imageView11.getLayoutParams() as ViewGroup.LayoutParams
                params.height = params.height - (scrollY - oldScrollY)/2
                imageView11.setLayoutParams(params)
            } else {
                val params: ViewGroup.LayoutParams = imageView11.getLayoutParams() as ViewGroup.LayoutParams
                params.height = params.height + (oldScrollY - scrollY)/2
                imageView11.setLayoutParams(params)
            }
        }

    }
}
