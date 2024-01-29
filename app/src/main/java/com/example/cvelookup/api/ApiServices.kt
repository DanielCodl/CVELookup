package com.example.cvelookup.api

import com.example.cvelookup.model.CveJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {

    @GET("2.0")
    suspend fun getCveJson(@Query("cveId") cveId : String) : Response<CveJson>


}