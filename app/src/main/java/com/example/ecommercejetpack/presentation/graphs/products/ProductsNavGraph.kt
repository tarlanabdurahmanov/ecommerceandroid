package com.example.ecommercejetpack.presentation.graphs.products


import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.presentation.graphs.Graph
import com.example.ecommercejetpack.presentation.products.ProductDetailScreen
import com.example.ecommercejetpack.presentation.products.ProductsHomeScreen


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun NavGraphBuilder.productsNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = ProductsRoutes.ProductHomeScreen.route, route = Graph.PRODUCTS
    ) {

        composable(ProductsRoutes.ProductHomeScreen.route) {
            ProductsHomeScreen(navHostController)
        }
        composable(ProductsRoutes.ProductDetailScreen.route) {
            ProductDetailScreen(navHostController)
        }

    }
}