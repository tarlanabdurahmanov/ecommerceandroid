package com.example.ecommercejetpack.domain.model


data class AuthModel(
    val token: String? = null,
    val user: User? = null,
    val message: String? = null,
)

data class User(
    val name: String? = null,
    val email: String? = null,
    val id: Long? = null,
)
