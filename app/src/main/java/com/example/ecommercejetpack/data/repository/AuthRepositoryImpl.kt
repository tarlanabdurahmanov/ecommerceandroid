package com.example.ecommercejetpack.data.repository


import com.example.ecommercejetpack.data.remote.AuthApi
import com.example.ecommercejetpack.data.remote.dto.LoginDto
import com.example.ecommercejetpack.data.remote.dto.RegisterDto
import com.example.ecommercejetpack.domain.model.AuthModel
import com.example.ecommercejetpack.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(private val api: AuthApi) : AuthRepository {
    override suspend fun login(body: LoginDto): Response<AuthModel> {
        return api.login(body)
    }

    override suspend fun register(body: RegisterDto): Response<AuthModel> {
        return api.register(body)
    }
}