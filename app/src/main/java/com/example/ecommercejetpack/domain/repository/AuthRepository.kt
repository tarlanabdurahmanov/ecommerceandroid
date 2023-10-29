package com.example.ecommercejetpack.domain.repository

import com.example.ecommercejetpack.data.remote.dto.LoginDto
import com.example.ecommercejetpack.data.remote.dto.RegisterDto
import com.example.ecommercejetpack.domain.model.AuthModel
import retrofit2.Response


interface AuthRepository {
    suspend fun login(body: LoginDto): Response<AuthModel>? = null
    suspend fun register(body: RegisterDto): Response<AuthModel>? = null
}