package com.example.ecommercejetpack.data.remote

import com.example.ecommercejetpack.common.Constants
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApi {
    @POST(Constants.PRODUCTS)
    suspend fun getProducts(): Response<ProductModel>

    @POST(Constants.PRODUCT_DETAIL)
    suspend fun productDetail(@Path("productId") productId: Int): Response<ProductDetailModel>
}