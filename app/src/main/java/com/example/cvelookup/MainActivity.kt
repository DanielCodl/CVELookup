package com.example.cvelookup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cvelookup.api.ApiServices
import com.example.cvelookup.api.RetrofitInstance
import com.example.cvelookup.database.CveDTO
import com.example.cvelookup.database.CveViewModel
import com.example.cvelookup.databinding.ActivityMainBinding
import com.example.cvelookup.model.CveJson
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var mCveViewModel: CveViewModel
    private lateinit var binding: ActivityMainBinding
    //private lateinit var viewModel: CveJsonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pridani View Binding - prakticky
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mCveViewModel =ViewModelProvider(this).get(CveViewModel::class.java)





val tv_cve_num_view = binding.tvCveNum // findViewById<TextView>(R.id.tv_cve_num)
val tv_cve_date_view = binding.tvCveDate // findViewById<TextView>(R.id.tv_cve_date)
val tv_cve_desc_view = binding.tvCveDesc // findViewById<TextView>(R.id.tv_cve_desc)
val bt_submit_cve_button = binding.btSubmitCve // findViewById<Button>(R.id.bt_submit_cve)
val bt_search_history = binding.btRecent
val bt_scan_ocr_button = binding.btOcr
val bt_exit_button  = binding.btExit




bt_submit_cve_button.setOnClickListener() {
    if (binding.evCveNum.text.isEmpty()){
        Toast.makeText(this@MainActivity, "CVE number cannot be empty!", Toast.LENGTH_SHORT).show()
    } else{
        //val cveId : String = "CVE-2019-1010218"
        // binding.evCveNum.text.clear()

        binding.progressBar.visibility= View.VISIBLE


            val retrofitService =
                RetrofitInstance.getRetrofitInstance().create(ApiServices::class.java)

            val responseLiveData: LiveData<Response<CveJson>> =

                liveData {
                    val response = retrofitService.getCveJson(binding.evCveNum.text.toString())
                    emit(response)
                }




            responseLiveData.observe(this, Observer {
                // Handle API call errors - output is NULL
                if (it.body() != null) {
                    tv_cve_num_view.text = it.body()?.vulnerabilities!![0].cve.id
                    tv_cve_date_view.text = it.body()?.vulnerabilities!![0].cve.published
                    tv_cve_desc_view.text = it.body()?.vulnerabilities!![0].cve.descriptions[0].value

                    val cveid: String = tv_cve_num_view.text.toString()
                    val published: String = tv_cve_date_view.text.toString()
                    val description: String = tv_cve_desc_view.text.toString()

                    val record = CveDTO(0, cveid, published, description)

                    mCveViewModel.addCve(record)

                    Toast.makeText(this@MainActivity, "Success!", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this@MainActivity, "Error fetching data from REST API - CVE "+binding.evCveNum.text.toString()+" does NOT exist!", Toast.LENGTH_LONG).show()
                }
                binding.evCveNum.text.clear()
                binding.progressBar.visibility = View.INVISIBLE
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