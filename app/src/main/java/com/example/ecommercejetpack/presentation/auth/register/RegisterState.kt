package com.example.ecommercejetpack.presentation.auth.register

import com.example.ecommercejetpack.domain.model.AuthModel

data class RegisterState(
    val isLoading: Boolean = false,
    val data: AuthModel? = null,
    val errorMessage: String? = null
)