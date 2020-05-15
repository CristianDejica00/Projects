package com.example.hq

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var clickTextBlock = findViewById(R.id.textView) as TextView
        val text = "By continuing you agree to the Terms of Use and Privacy Policy"
        val ssBuilder = SpannableStringBuilder(text)
        val firstClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(i)
            }
        }
        val secondClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(i)
            }
        }
        ssBuilder.setSpan(
            firstClickableSpan, // Span to add
            31, 43, // End of the span (exclusive)
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Do not extend the span when text add later
        );
        ssBuilder.setSpan(
            secondClickableSpan, // Span to add
            48, 62, // End of the span (exclusive)
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Do not extend the span when text add later
        );
        clickTextBlock.setText(ssBuilder);
        clickTextBlock.setMovementMethod(LinkMovementMethod.getInstance());
        clickTextBlock.setHighlightColor(Color.TRANSPARENT);
        button.setOnClickListener {
            val intent = Intent(this, Login_Main::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, RegisterMain::class.java)
            startActivity(intent)
        }

    }
}
