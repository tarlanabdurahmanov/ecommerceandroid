package com.example.ecommercejetpack.data.repository


import com.example.ecommercejetpack.data.remote.ProductApi
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import com.example.ecommercejetpack.domain.repository.ProductRepository
import retrofit2.Response

import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: ProductApi) : ProductRepository {
    override suspend fun getProducts(): Response<ProductModel> {
        return api.getProducts()
    }

    override suspend fun productDetail(productId: Int): Response<ProductDetailModel> {
        return api.productDetail(productId = productId)
    }

}