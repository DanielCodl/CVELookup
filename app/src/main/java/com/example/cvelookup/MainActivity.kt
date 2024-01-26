package com.example.cvelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cvelookup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pridani View Binding - prakticky
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val tv_cve_num_view = binding.tvCveNum // findViewById<TextView>(R.id.tv_cve_num)
        val tv_cve_date_view = binding.tvCveDate // findViewById<TextView>(R.id.tv_cve_date)
        val tv_cve_desc_view = binding.tvCveDesc // findViewById<TextView>(R.id.tv_cve_desc)
        val bt_submit_cve_button = binding.btSubmitCve // findViewById<Button>(R.id.bt_submit_cve)

        bt_submit_cve_button.setOnClickListener() {
            if (binding.evCveNum.text.isEmpty()){
                Toast.makeText(this@MainActivity, "CVE number cannot be empty!", Toast.LENGTH_SHORT).show()
            } else{
            binding.evCveNum.text.clear()
            tv_cve_num_view.text= binding.evCveNum.text.toString() // findViewById<EditText>(R.id.ev_cve_num).text.toString()
            tv_cve_date_view.text=getString(R.string.cve_date_test)
            tv_cve_desc_view.text=getString(R.string.cve_desc_test)
            }
        }
    }
}