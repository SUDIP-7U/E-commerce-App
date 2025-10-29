package com.example.fakeapistore.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import com.example.fakeapistore.BaseFragment
import com.example.fakeapistore.MainViewModel
import com.example.fakeapistore.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id= requireArguments().getInt("itemId")
        Log.d("TAG", id.toString())
        viewModel.getProduct(id)
        setProductObserver()

    }

    @SuppressLint("SetTextI18n")
    private fun setProductObserver(){
        viewModel.productResponse.observe(viewLifecycleOwner){ product ->

            Log.d("T", product.toString())

            binding.apply {
                pdprice.text = "$${product.price}"
                pdtitle.text = product.title
                pddiscount.text ="${product.discountPercentage}"
                pddiscribtion.text =product.description
                pdImage.load(product.thumbnail)
                setImgSilder(product.images as List<String>?)
                Log.d("TAGG", product.images.toString())

            }
        }
    }

    private fun setImgSilder(images: List<String>?) {
        if (!images.isNullOrEmpty()){
//            binding.productimg.adapter = StoreSliderAdapter(images)
        }

    }


}