package com.example.ecommercejetpack.presentation.auth.login

import com.example.ecommercejetpack.domain.model.AuthModel


data class LoginState(
    val isLoading: Boolean = false,
    val data: AuthModel? = null,
    val errorMessage: String? = null
)