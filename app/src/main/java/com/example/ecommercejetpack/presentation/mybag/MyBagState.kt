package com.example.ecommercejetpack.presentation.mybag

import com.example.ecommercejetpack.domain.model.ProductCartModel

data class MyBagState(
    val isLoading: Boolean = false,
    val data: ProductCartModel? = null,
    val errorMessage: String? = null,
)