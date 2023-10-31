package com.example.ecommercejetpack.domain.model

import com.google.gson.annotations.SerializedName


data class ProductModel(
    val products: List<Product>? = null,
)

data class Product(
    val id: Long? = null,
    @SerializedName("cover_image") val coverImage: String? = null,
    val price: String? = null,
    @SerializedName("old_price") val oldPrice: String? = null,
    val hot: Boolean? = null,
    val new: Boolean? = null,
    val name: String? = null,
    val slug: String? = null,
)