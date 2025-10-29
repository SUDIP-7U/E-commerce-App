package com.example.fakeapistore.remote

import com.example.fakeapistore.PRODUCT
import com.example.fakeapistore.PRODUCTS
import com.example.fakeapistore.data.ResponseProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(PRODUCTS)
    suspend fun getAllProduct(): Response<ResponseProducts>

    @GET(PRODUCT)
    suspend fun getProduct(@Path("id") id: Int): Response<ResponseProducts.Product>
}