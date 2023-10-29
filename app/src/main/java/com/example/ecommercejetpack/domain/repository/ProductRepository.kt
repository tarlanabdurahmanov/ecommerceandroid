package com.example.ecommercejetpack.domain.repository


import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductModel
import retrofit2.Response

interface ProductRepository {
    suspend fun getProducts(): Response<List<Product>>? = null
//    suspend fun createProduct(body: CreateProductDto): Response<ProductModel>? = null
//    suspend fun updateProduct(body: UpdateProductDto, productId: String): Response<ProductModel>? = null
//    suspend fun deleteProduct(productId: String): Response<ProductModel>? = null
}