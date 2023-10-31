package com.example.ecommercejetpack.data.remote


import com.example.ecommercejetpack.data.remote.dto.RegisterDto
import com.example.ecommercejetpack.data.remote.dto.LoginDto
import com.example.ecommercejetpack.domain.model.AuthModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthApi {
    @POST("register")
    suspend fun register(@Body body: RegisterDto): Response<AuthModel>


    @Headers("Accept: application/json")
    @POST("login")
    suspend fun login(@Body body: LoginDto): Response<AuthModel>
}