package com.example.cvelookup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cvelookup.api.ApiServices
import com.example.cvelookup.api.RetrofitInstance
import com.example.cvelookup.databinding.ActivityMainBinding
import com.example.cvelookup.model.CveJson
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var viewModel: CveJsonViewModel

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
val bt_search_history = binding.btRecent
val bt_exit_button  = binding.btExit

bt_submit_cve_button.setOnClickListener() {
    if (binding.evCveNum.text.isEmpty()){
        Toast.makeText(this@MainActivity, "CVE number cannot be empty!", Toast.LENGTH_SHORT).show()
    } else{
        val cveId : String = "CVE-2019-1010218"
        //binding.evCveNum.text.clear()
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(ApiServices::class.java)
        val responseLiveData: LiveData<Response<CveJson>> =

            liveData {
                val response = retrofitService.getCveJson("CVE-2022-38392")
                emit(response)
            }

        responseLiveData.observe(this, Observer {
            //tv_cve_num_view.text= it.body()?.totalResults.toString()
            tv_cve_num_view.text= it.body()?.vulnerabilities!![0].cve.id
            tv_cve_date_view.text= it.body()?.vulnerabilities!![0].cve.published
            tv_cve_desc_view.text= it.body()?.vulnerabilities!![0].cve.descriptions[0].value
        })
    }
}

bt_search_history.setOnClickListener(){
    val intent = Intent(this,SearchHistoryActivity::class.java)

    startActivity(intent)
}

bt_exit_button.setOnClickListener(){
    //finish()
    // on below line we are exiting our activity
    System.exit(0)
}
}
}