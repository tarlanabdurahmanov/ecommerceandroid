package com.example.ecommercejetpack.presentation.bottomnavigation

import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.presentation.graphs.bottom.BottomNavigationRoutes

sealed class BottomItem(
    val title: String,
    val icon: Int,
    val activeIcon: Int,
    val route: String,
) {
    object HomeScreen : BottomItem(
        "Home", R.drawable.home,
        R.drawable.active_home,
        BottomNavigationRoutes.HomeScreen.route
    )

    object ShoppingScreen : BottomItem(
        "Shop",
        R.drawable.shopping_cart,
        R.drawable.acvtive_shopping_cart,
        BottomNavigationRoutes.ShoppingScreen.route
    )

    object BagScreen : BottomItem(
        "Bag", R.drawable.bag,
        R.drawable.activate_bag,
        BottomNavigationRoutes.BagScreen.route
    )

    object FavouritesScreen : BottomItem(
        "Favorites",
        R.drawable.heart,
        R.drawable.avtive_heart,
        BottomNavigationRoutes.FavouritesScreen.route
    )

    object UserScreen : BottomItem(
        "Profile",
        R.drawable.account_circle,
        R.drawable.active_account_circle,
        BottomNavigationRoutes.UserScreen.route
    )
}