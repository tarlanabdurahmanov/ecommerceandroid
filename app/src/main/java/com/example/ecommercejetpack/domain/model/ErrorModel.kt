package com.example.ecommercejetpack.domain.model

import org.json.JSONObject

data class ErrorModel(
    val message: String? = null,
    val errors: JSONObject? = null,
)
