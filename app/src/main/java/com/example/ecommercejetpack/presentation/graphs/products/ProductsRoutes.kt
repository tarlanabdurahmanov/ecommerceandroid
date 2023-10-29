package com.example.ecommercejetpack.presentation.graphs.products

sealed class ProductsRoutes(val route: String) {
    object ProductScreen : ProductsRoutes("products_screen")
    object ProductHomeScreen : ProductsRoutes("product_home_screen")
}