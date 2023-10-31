package com.example.ecommercejetpack.domain.model

data class FavouriteModel(
    val favourites: List<Favourite>? = null,
)

data class Favourite(
    val id: Long? = null,
    val productID: Long? = null,
    val name: String? = null,
    val slug: String? = null,
    val coverImage: String? = null,
    val price: String? = null,
    val oldPrice: String? = null,
    val hot: Boolean? = null,
    val new: Boolean? = null,
    val inStock: Boolean? = null,
)
