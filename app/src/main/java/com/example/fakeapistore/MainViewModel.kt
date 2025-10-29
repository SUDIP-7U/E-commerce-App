package com.example.fakeapistore

import com.example.fakeapistore.data.ResponseProducts
import com.example.fakeapistore.remote.RetrofitClient
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _allProductResponse = MutableLiveData<ResponseProducts>()
    val allProductResponse: LiveData<ResponseProducts> = _allProductResponse

    fun getAllProduct() {
        viewModelScope.launch {
            val data = RetrofitClient.getApiDAO().getAllProduct().body()
            _allProductResponse.postValue(data!!)
        }
    }

    private val _productResponse = MutableLiveData<ResponseProducts.Product>()
    val productResponse: LiveData<ResponseProducts.Product> = _productResponse

    fun getProduct(pid:Int) {
        viewModelScope.launch {
            val data = RetrofitClient.getApiDAO().getProduct(pid).body()
            _productResponse.postValue(data!!)

        }
    }
}