package com.example.ecommercejetpack.di

import com.example.ecommercejetpack.common.Constants
import com.example.ecommercejetpack.data.remote.AuthApi
import com.example.ecommercejetpack.data.remote.AuthInterceptor
import com.example.ecommercejetpack.data.remote.ProductApi
import com.example.ecommercejetpack.data.repository.AuthRepositoryImpl
import com.example.ecommercejetpack.data.repository.ProductRepositoryImpl
import com.example.ecommercejetpack.domain.repository.AuthRepository
import com.example.ecommercejetpack.domain.repository.ProductRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        ).baseUrl(Constants.BASE_URL)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        authInterceptor: AuthInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Provides
    @Singleton
    fun providesAuthApi(retrofitBuilder: Retrofit.Builder): AuthApi {
        return retrofitBuilder.build().create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun providesProductsApi(retrofitBuilder: Builder, okHttpClient: OkHttpClient): ProductApi {
        return retrofitBuilder.client(okHttpClient).build().create(ProductApi::class.java)
    }


    @Provides
    @Singleton
    fun providesAuthRepository(api: AuthApi): AuthRepository {
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesProductsRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }
}