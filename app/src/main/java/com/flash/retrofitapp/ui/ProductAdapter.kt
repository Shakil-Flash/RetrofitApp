package com.flash.retrofitapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flash.retrofitapp.data.Product
import com.flash.retrofitapp.databinding.ProductItemBinding

class ProductAdapter(private val products: List<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(flash: ViewHolder, p1: Int) {
        val product = products[p1]
        flash.binding.productName.text = product.title
        flash.binding.productDescription.text = product.description
        flash.binding.productPrice.text = "$${product.price}"
        Glide.with(flash.itemView.context)
            .load(product.image)
            .into(flash.binding.productImage)



    }

    override fun getItemCount(): Int = products.size


}