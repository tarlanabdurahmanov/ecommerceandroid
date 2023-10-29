package com.example.ecommercejetpack.data.remote


import com.example.ecommercejetpack.common.Preferences
import okhttp3.Interceptor
import okhttp3.Response

import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val preferences: Preferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val token: String? = preferences.getToken()
        val request = chain.request().newBuilder()
        request.addHeader("authorization", "Bearer $token")
        request.addHeader("Accept", "application/json")


        return chain.proceed(request.build())
    }
}