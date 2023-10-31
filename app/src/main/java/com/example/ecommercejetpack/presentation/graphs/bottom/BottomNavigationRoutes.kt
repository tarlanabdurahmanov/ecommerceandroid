package com.example.ecommercejetpack.presentation.graphs.bottom


sealed class BottomNavigationRoutes(val route: String) {
    object HomeScreen : BottomNavigationRoutes("home_screen")
    object ShoppingScreen : BottomNavigationRoutes("shopping_screen")
    object BagScreen : BottomNavigationRoutes("bag_screen")
    object FavouritesScreen : BottomNavigationRoutes("favourites_screen")
    object UserScreen : BottomNavigationRoutes("user_screen")
}