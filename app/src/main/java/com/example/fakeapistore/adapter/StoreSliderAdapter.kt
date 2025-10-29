package com.example.fakeapistore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fakeapistore.databinding.PdImgSliderBinding


class StoreSliderAdapter(var itemlist :List<String>?) : RecyclerView.Adapter<StoreSliderAdapter.Productviewholder>() {

    class Productviewholder(val binding: PdImgSliderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Productviewholder {
        val binding = PdImgSliderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Productviewholder(binding)
    }
    override fun getItemCount(): Int {
        return itemlist?.size ?: 0
    }
    override fun onBindViewHolder(holder: StoreSliderAdapter.Productviewholder, position: Int) {
        itemlist?.get(position).let {

            holder.binding.productimgs.load(it)

        }
    }
}