package com.example.ecommercejetpack.presentation.graphs

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecommercejetpack.presentation.bottomnavigation.bottomNavGraph
import com.example.ecommercejetpack.presentation.graphs.auth.authNavGraph
import com.example.ecommercejetpack.presentation.graphs.products.ProductsRoutes
import com.example.ecommercejetpack.presentation.graphs.products.productsNavGraph
import com.example.ecommercejetpack.presentation.splash.SplashScreen


@Composable
fun RootNavigationGraph(navHostController: NavHostController, context: Context) {
    NavHost(
        navController = navHostController, route = Graph.ROOT, startDestination = Graph.SPLASH
    ) {
        authNavGraph(navHostController, context)
        productsNavGraph(navHostController = navHostController)
        composable(Graph.SPLASH) {
            SplashScreen(navigate = { isUserExist ->
                if (isUserExist) {
                    navHostController.popBackStack()
                    navHostController.navigate(ProductsRoutes.ProductHomeScreen.route)
                } else {
                    navHostController.navigate(Graph.AUTHENTICATION)
                }
            })
        }
    }
}