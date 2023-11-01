package com.example.ecommercejetpack.data.remote.dto

import com.google.gson.annotations.SerializedName


data class ProductCartDto(
    val type: Int,
    val count: Int? = 1,
    @SerializedName("product_id") val productId: Int? = null,
    @SerializedName("color_id") val colorId: Int? = null,
    @SerializedName("size_id") val sizeId: Int? = null,
    @SerializedName("cart_id") val cartId: Int? = null,

    )