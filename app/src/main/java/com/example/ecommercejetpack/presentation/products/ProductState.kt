package com.example.ecommercejetpack.presentation.products

import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductModel


data class ProductState(
    val isLoading: Boolean = false,
    val data: ProductModel? = null,
    val errorMessage: String? = null,
)