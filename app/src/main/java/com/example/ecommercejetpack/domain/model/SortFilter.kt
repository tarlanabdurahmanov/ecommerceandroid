package com.example.ecommercejetpack.domain.model

data class SortFilter(
    val name: String, val value: Int
)

val sortsFilter = listOf<SortFilter>(
    SortFilter(name = "Popular", value = 0),
    SortFilter(name = "Newest", value = 1),
    SortFilter(name = "Customer review", value = 2),
    SortFilter(name = "Price: lowest to high", value = 3),
    SortFilter(name = "Price: highest to low", value = 4),
)