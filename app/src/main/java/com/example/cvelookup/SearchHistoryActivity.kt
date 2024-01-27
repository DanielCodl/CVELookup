package com.example.cvelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_history)

        val bt_return_button = findViewById<Button>(R.id.bt_return)

        bt_return_button.setOnClickListener(){
            finish()
        }
    }
}