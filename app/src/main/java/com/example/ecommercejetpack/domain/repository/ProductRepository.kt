package com.example.ecommercejetpack.domain.repository


import com.example.ecommercejetpack.data.remote.dto.ProductCartDto
import com.example.ecommercejetpack.data.remote.dto.ProductDetailDto
import com.example.ecommercejetpack.domain.model.AddEditProductCartModel
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductCartModel
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import retrofit2.Response

interface ProductRepository {
    suspend fun getProducts(): Response<ProductModel>

    suspend fun productDetail(productDetailDto: ProductDetailDto): Response<ProductDetailModel>
    suspend fun productCarts(): Response<ProductCartModel>
    suspend fun addEditProductCarts(productCartDto: ProductCartDto): Response<AddEditProductCartModel>
}