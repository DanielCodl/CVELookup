package com.example.cvelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv_cve_num_view = findViewById<TextView>(R.id.tv_cve_num)
        val tv_cve_date_view = findViewById<TextView>(R.id.tv_cve_date)
        val tv_cve_desc_view = findViewById<TextView>(R.id.tv_cve_desc)
        val bt_submit_cve_button = findViewById<Button>(R.id.bt_submit_cve)
        bt_submit_cve_button.setOnClickListener() {
            tv_cve_num_view.text=findViewById<EditText>(R.id.ev_cve_num).text.toString()
            tv_cve_date_view.text=getString(R.string.cve_date_test)
            tv_cve_desc_view.text=getString(R.string.cve_desc_test)
        }
    }
}