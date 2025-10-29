package com.example.fakeapistore.remote

import com.example.fakeapistore.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private fun getRetrofitInstance() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiDAO() = getRetrofitInstance().create(ApiService::class.java)!!

}