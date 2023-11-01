package com.example.ecommercejetpack.data.repository


import com.example.ecommercejetpack.data.remote.ProductApi
import com.example.ecommercejetpack.data.remote.dto.ProductCartDto
import com.example.ecommercejetpack.data.remote.dto.ProductDetailDto
import com.example.ecommercejetpack.domain.model.AddEditProductCartModel
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductCartModel
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import com.example.ecommercejetpack.domain.repository.ProductRepository
import retrofit2.Response

import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: ProductApi) : ProductRepository {
    override suspend fun getProducts(): Response<ProductModel> {
        return api.getProducts()
    }

    override suspend fun productDetail(productDetailDto: ProductDetailDto): Response<ProductDetailModel> {
        return api.productDetail(productDetailDto)
    }

    override suspend fun productCarts(): Response<ProductCartModel> {
        return api.productCarts()
    }

    override suspend fun addEditProductCarts(productCartDto: ProductCartDto): Response<AddEditProductCartModel> {
        return api.addEditProductCarts(productCartDto)
    }


}