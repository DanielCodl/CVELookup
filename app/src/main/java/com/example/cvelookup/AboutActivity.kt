package com.example.cvelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val bt_return_button = findViewById<Button>(R.id.bt_return2)

        bt_return_button.setOnClickListener() {
            finish()
        }

    }
}