package com.example.ecommercejetpack.domain.model


data class ProductDetailModel (
    val product: ProductDetail? = null,
    val images: List<Image>? = null,
    val sizes: List<Any?>? = null,
    val colors: List<Any?>? = null,
    val features: List<Feature>? = null,
    val similarProducts: List<SimilarProduct>? = null
)

data class Feature (
    val id: Long? = null,
    val productID: Long? = null,
    val langID: Long? = null,
    val key: String? = null,
    val value: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)

data class Image (
    val id: Long? = null,
    val productID: Long? = null,
    val image: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)

data class ProductDetail (
    val id: Long? = null,
    val price: String? = null,
    val oldPrice: String? = null,
    val hot: Boolean? = null,
    val new: Boolean? = null,
    val inStock: Boolean? = null,
    val name: String? = null,
    val slug: String? = null,
    val shortInfo: String? = null,
    val description: String? = null,
    val category: Any? = null
)

data class SimilarProduct (
    val id: Long? = null,
    val coverImage: String? = null,
    val price: String? = null,
    val oldPrice: String? = null,
    val hot: Boolean? = null,
    val new: Boolean? = null,
    val name: String? = null,
    val slug: String? = null
)
