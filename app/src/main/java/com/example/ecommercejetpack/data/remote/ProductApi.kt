package com.example.ecommercejetpack.data.remote

import com.example.ecommercejetpack.common.Constants
import com.example.ecommercejetpack.data.remote.dto.ProductCartDto
import com.example.ecommercejetpack.data.remote.dto.ProductDetailDto
import com.example.ecommercejetpack.domain.model.AddEditProductCartModel
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.domain.model.ProductCartModel
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @POST(Constants.PRODUCTS)
    suspend fun getProducts(): Response<ProductModel>

    @POST(Constants.PRODUCT_DETAIL)
    suspend fun productDetail(@Body body: ProductDetailDto): Response<ProductDetailModel>


    @POST(Constants.PRODUCT_CARTS)
    suspend fun productCarts(): Response<ProductCartModel>

    @POST(Constants.ADD_EDIT_PRODUCT_CARTS)
    suspend fun addEditProductCarts(@Body body: ProductCartDto): Response<AddEditProductCartModel>
}