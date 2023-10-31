package com.example.ecommercejetpack.presentation.bottomnavigation


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.presentation.category.CategoryScreen
import com.example.ecommercejetpack.presentation.filters.FiltersScreen
import com.example.ecommercejetpack.presentation.graphs.Graph
import com.example.ecommercejetpack.presentation.graphs.bottom.BottomNavigationRoutes
import com.example.ecommercejetpack.presentation.home.HomeScreen
import com.example.ecommercejetpack.presentation.mybag.MyBagScreen
import com.example.ecommercejetpack.presentation.products.ProductDetailScreen
import com.example.ecommercejetpack.presentation.products.ProductsHomeScreen


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavGraphBuilder.bottomNavGraph(
    navController: NavController,
) {
    composable(BottomNavigationRoutes.HomeScreen.route) {
        HomeScreen(navController)
    }

    composable(BottomNavigationRoutes.ShoppingScreen.route) {
        CategoryScreen()
    }

    composable(BottomNavigationRoutes.BagScreen.route) {
        MyBagScreen()
    }

    composable(BottomNavigationRoutes.FavouritesScreen.route) {
        ProductDetailScreen(navController)
    }
    composable(BottomNavigationRoutes.UserScreen.route) {
        FiltersScreen()
    }

}