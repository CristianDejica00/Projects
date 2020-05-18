package com.example.hq

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_quest_reacts.*

class QuestReacts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_reacts)

        button21.setOnClickListener {
            val intent = Intent(this, MainFeed::class.java)
            startActivity(intent)
        }
        button22.setOnClickListener {
            val intent = Intent(this, CreateQuest::class.java)
            startActivity(intent)
        }
        /*button23.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }*/
        button24.setOnClickListener {
            val intent = Intent(this, ProfileMain::class.java)
            startActivity(intent)
        }

        val listView = findViewById<LinearLayout>(R.id.reacts_scroll_wraper)

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

        /*listView.adapter = QuestReacts.CustomAdapter(this, nameList)
        listView.setDivider(null)*/

        val inflater = LayoutInflater.from(this)
        for (item in nameList) {
            val view  = inflater.inflate(R.layout.react_layout, listView, false)

            val postName = view.findViewById<TextView>(R.id.post_header_name)
            postName.text = item

            listView.addView(view)
        }

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
            val postBlock = layoutInflater.inflate(R.layout.react_layout, parent, false)

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
