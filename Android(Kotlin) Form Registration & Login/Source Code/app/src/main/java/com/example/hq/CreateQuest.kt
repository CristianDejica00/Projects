package com.example.hq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_create_quest.*

class CreateQuest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quest)


        button21.background.setAlpha(70);
        button22.background.setAlpha(255);
        button23.background.setAlpha(70);
        button24.background.setAlpha(70);
        button25.background.setAlpha(70);
        button26.background.setAlpha(70);

        button21.setOnClickListener {
            val intent = Intent(this, MainFeed::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.left_to_right_enter, R.anim.left_to_right_exit)
        }
        button23.setOnClickListener {
            val intent = Intent(this, SettingsMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }
        button24.setOnClickListener {
            val intent = Intent(this, ProfileMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }


        button21.background.setAlpha(70);
        button23.background.setAlpha(70);
        button24.background.setAlpha(70);
        button25.background.setAlpha(70);
        button26.background.setAlpha(70);

        textView12.setText("Create a quest")
        textView13.setText("Your quest will be automatically deleted after 24 hours, but you can always delete it yourself beforehand.")
        editText7.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                textView14.setText(editText7.text.length.toString() + " / 300")
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })




    }

}
