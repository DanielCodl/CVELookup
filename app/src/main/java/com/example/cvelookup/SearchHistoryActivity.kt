package com.example.cvelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvelookup.database.CveViewModel

class SearchHistoryActivity : AppCompatActivity() {

    private lateinit var mCveViewModel: CveViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_history)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview1)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =LinearLayoutManager(this)

        // CveViewModel
        mCveViewModel = ViewModelProvider(this).get(CveViewModel::class.java)
        mCveViewModel.readAllData.observe(this, Observer { cve-> adapter.setData(cve)
        })

        val bt_return_button = findViewById<Button>(R.id.bt_return)

        bt_return_button.setOnClickListener(){
            finish()
        }
    }
}