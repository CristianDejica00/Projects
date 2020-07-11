package com.example.hq

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.activity_main_feed.*


class MainFeed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_feed)



        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")




        button15.background.setAlpha(255);
        button16.background.setAlpha(70);
        button17.background.setAlpha(70);
        button18.background.setAlpha(70);
        button19.background.setAlpha(70);
        button20.background.setAlpha(70);

        button16.setOnClickListener {
            val intent = Intent(this, CreateQuest::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }
        button17.setOnClickListener {
            val intent = Intent(this, SettingsMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }
        button18.setOnClickListener {
            val intent = Intent(this, ProfileMain::class.java)
            startActivity(intent)
            this.overridePendingTransition(R.anim.right_to_left_enter, R.anim.right_to_left_exit)
        }


        val listView = findViewById<ListView>(R.id.mainfeedwrapper)




        val nameList = listOf<String>(
            "Donald Trump",
            "Dave Grohl",
            "James Hetfield",
            "Steve Jobs",
            "Dave Grohl",
            "James Hetfield",
            "Steve Jobs",
            "Dave Grohl",
            "James Hetfield",
            "Steve Jobs",
            "Dave Grohl",
            "James Hetfield",
            "Steve Jobs"
        )

        listView.adapter = CustomAdapter(this, nameList)
        listView.setDivider(null)

    }

    private class CustomAdapter(context: Context, list: List<String>): BaseAdapter() {

        private val mContext: Context
        private val list: List<String>

        init {
            this.mContext = context
            this.list = list
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val postBlock = layoutInflater.inflate(R.layout.quest_layout, parent, false)

            val postName = postBlock.findViewById<TextView>(R.id.post_header_name)
            postName.text = list.get(position)



            return postBlock

        }

        override fun getItem(position: Int): Any {
            return "Test string"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return list.size
        }
    }
}
