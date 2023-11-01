package com.example.ecommercejetpack.domain.model

import com.google.gson.annotations.SerializedName


data class ProductCartModel(
    val carts: List<Cart>? = null,
)

data class Cart(
    val id: Long? = null,
    @SerializedName("product_id")
    val productID: Long? = null,
    val name: String? = null,
    @SerializedName("cover_image")
    val coverImage: String? = null,
    val price: Int? = null,
    val size: Long? = null,
    val color: String? = null,
)
