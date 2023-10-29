package com.example.ecommercejetpack.presentation.auth.login

import com.example.ecommercejetpack.domain.model.AuthModel
import org.json.JSONObject


data class LoginState(
    val isLoading: Boolean = false,
    val data: AuthModel? = null,
    var errorMessage: String? = null,
)