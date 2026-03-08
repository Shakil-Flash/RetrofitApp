package com.flash.retrofitapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.flash.retrofitapp.R
import com.flash.retrofitapp.data.ApiClient
import com.flash.retrofitapp.data.Product
import com.flash.retrofitapp.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        loadProducts()
    }

    private fun loadProducts() {
        ApiClient.api.getProducts().enqueue(object : Callback<List<Product>>{
            override fun onResponse(
                p0: Call<List<Product>?>?,
                p1: Response<List<Product>?>?
            ) {
                if(p1?.isSuccessful ?: false) {
                    val product = p1.body() ?: emptyList()
                    binding.recyclerView.adapter = ProductAdapter(product)

                }
            }

            override fun onFailure(p0: Call<List<Product>?>?, p1: Throwable) {
                Toast.makeText(this@HomeActivity, "Error: ${p1.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}