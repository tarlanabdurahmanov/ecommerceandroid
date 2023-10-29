package com.example.ecommercejetpack.data.repository


import com.example.ecommercejetpack.data.remote.ProductApi
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.repository.ProductRepository
import retrofit2.Response

import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: ProductApi) : ProductRepository {
    override suspend fun getProducts(): Response<List<Product>> {
        return api.getProducts()
    }
//
//    override suspend fun createProduct(body: CreateProductDto): Response<ProductModel> {
//        return api.createProduct(body)
//    }
//
//    override suspend fun updateProduct(body: UpdateProductDto, productId: String): Response<ProductModel> {
//        return api.updateProduct(productId, body)
//    }
//
//    override suspend fun deleteProduct(productId: String): Response<ProductModel> {
//        return api.deleteProduct(productId)
//    }
}