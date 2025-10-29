package com.example.fakeapistore.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fakeapistore.R
import com.example.fakeapistore.data.ResponseProducts
import com.example.fakeapistore.databinding.ItemBinding

class ListAdapter(private var itemlist :List<ResponseProducts.Product>?) : RecyclerView.Adapter<ListAdapter.Itemviewholder>() {

    class Itemviewholder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemviewholder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Itemviewholder(binding)
    }

    override fun getItemCount(): Int {
        return itemlist?.size ?: 0
    }

    override fun onBindViewHolder(holder: Itemviewholder, position: Int) {
        itemlist?.get(position).let { product ->
            holder.binding.itemtext.text= product?.title
            holder.binding.itemprice.text = "$ ${product?.price}"

            holder.binding.itemimg.load(product?.thumbnail)
            holder.binding.root.setOnClickListener{ view ->

                view.findNavController().navigate(

                    R.id.action_productFragment_to_productDetailsFragment,
                    Bundle().apply {
                        putInt("itemId", product?.id!!)
                    }
                )
            }
        }
    }
}