package com.example.ecommercejetpack.presentation.products

import com.example.ecommercejetpack.domain.model.Product


data class ProductState(
    val isLoading: Boolean = false,
    val data: List<Product>? = null,
    val errorMessage: String? = null
)