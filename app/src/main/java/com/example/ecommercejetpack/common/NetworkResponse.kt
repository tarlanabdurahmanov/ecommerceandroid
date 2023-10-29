package com.example.ecommercejetpack.common

import com.example.ecommercejetpack.domain.model.ErrorModel
import org.json.JSONObject

sealed class NetworkResponse<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Loading<T>() : NetworkResponse<T>()
    class Success<T>(data: T? = null) : NetworkResponse<T>(data = data)
    class Error<T>(message: String? = null) : NetworkResponse<T>(message = message)
}