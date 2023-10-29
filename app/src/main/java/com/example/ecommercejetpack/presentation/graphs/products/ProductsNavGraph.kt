package com.example.ecommercejetpack.presentation.graphs.products


import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ecommercejetpack.domain.model.Product
import com.example.ecommercejetpack.presentation.graphs.Graph
import com.example.ecommercejetpack.presentation.products.ProductsHomeScreen


fun NavGraphBuilder.productsNavGraph(navHostController: NavHostController) {
    var productsData: Product? = null
    navigation(
        startDestination = ProductsRoutes.ProductHomeScreen.route, route = Graph.PRODUCTS
    ) {

        composable(ProductsRoutes.ProductHomeScreen.route) {
            ProductsHomeScreen()
//            onProductClick = { product ->
//                productsData = product
//                navHostController.navigate(ProductsRoutes.ProductHomeScreen.route)
//            }
        }
//        composable(ProductsRoutes.ProductScreen.route) {
//            ProductScreen(products = productsData, onBackPress = {
//                navHostController.popBackStack()
//            })
//        }

    }
}