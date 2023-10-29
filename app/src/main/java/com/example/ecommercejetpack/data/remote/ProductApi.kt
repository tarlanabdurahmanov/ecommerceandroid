package com.example.ecommercejetpack.data.remote

import com.example.ecommercejetpack.domain.model.Product
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApi {

    @GET("/api/products")
    suspend fun getProducts(): Response<List<Product>>

//    @POST("/api/product/create")
//    suspend fun createProduct(@Body body: CreateProductDto): Response<ProductModel>

//
//    @PUT("/api/products/{productId}")
//    suspend fun updateProduct(
//        @Path("productId") productId: String,
//        @Body body: UpdateProductDto
//    ): Response<ProductModel>
//
//    @DELETE("/api/products/{productId}")
//    suspend fun deleteProduct(@Path("productId") productId: String): Response<ProductModel>
}