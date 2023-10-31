package com.example.ecommercejetpack.domain.model

import com.google.gson.annotations.SerializedName


data class ProductDetailModel(
    val product: ProductDetail? = null,
    val images: List<Image>? = null,
    val sizes: List<Size>? = null,
    val colors: List<Color>? = null,
    val features: List<Feature>? = null,
    @SerializedName("similarProducts") val similarProducts: List<Product>? = null,
)

data class Color(
    @SerializedName("color_id") val colorID: Int? = null,
    val color: String? = null,
)

data class Feature(
    val id: Int? = null,
    @SerializedName("product_id") val productID: Int? = null,
    @SerializedName("lang_id") val langID: Int? = null,
    val key: String? = null,
    val value: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
)

data class Image(
    val id: Int? = null,
    @SerializedName("product_id") val productID: Int? = null,
    val image: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
)

data class ProductDetail(
    val id: Int? = null,
    val price: String? = null,
    @SerializedName("old_price") val oldPrice: String? = null,
    val hot: Boolean? = null,
    val new: Boolean? = null,
    @SerializedName("in_stock") val inStock: Boolean? = null,
    val name: String? = null,
    val slug: String? = null,
    @SerializedName("short_info") val shortInfo: String? = null,
    val description: String? = null,
    val category: String? = null,
)

data class Size(
    @SerializedName("size_id") val sizeID: Int? = null,
    val size: Int? = null,
)