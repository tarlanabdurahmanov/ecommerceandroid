package com.example.ecommercejetpack.presentation.products

import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel


data class ProductState(
    val isLoading: Boolean = false,
    val data: ProductModel? = null,
    val errorMessage: String? = null,
)


data class ProductDetailState(
    val isLoading: Boolean = false,
    val data: ProductDetailModel? = null,
    val errorMessage: String? = null,
)