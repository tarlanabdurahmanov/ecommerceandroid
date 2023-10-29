package com.example.ecommercejetpack.presentation.graphs.auth


import android.app.Activity
import android.content.Context
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ecommercejetpack.presentation.auth.forgotpassword.ForgotPasswordScreen
import com.example.ecommercejetpack.presentation.auth.login.LoginScreen
import com.example.ecommercejetpack.presentation.auth.register.RegisterScreen
import com.example.ecommercejetpack.presentation.graphs.Graph
import com.example.ecommercejetpack.presentation.graphs.products.ProductsRoutes

fun NavGraphBuilder.authNavGraph(navController: NavController, context: Context) {
    navigation(
        route = Graph.AUTHENTICATION, startDestination = AuthRoutes.SignInScreen.route
    ) {
        composable(route = AuthRoutes.SignInScreen.route) {
            LoginScreen(navController = navController, loading = { isLoading ->
                if (isLoading) {
                    (context as Activity).window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                } else {
                    (context as Activity).window.clearFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }
            }, signInSuccess = {
                (context as Activity).window.clearFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                )
                navController.popBackStack()
                navController.navigate(ProductsRoutes.ProductHomeScreen.route)
            })
        }
        composable(route = AuthRoutes.SignUpScreen.route) {
            RegisterScreen(navController = navController, signUpSuccess = {
                navController.popBackStack()
                navController.navigate(AuthRoutes.SignInScreen.route)
            }, loading = { isLoading ->
                if (isLoading) {
                    (context as Activity).window.setFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                } else {
                    (context as Activity).window.clearFlags(
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    )
                }
            })
        }
        composable(route = AuthRoutes.ForgotPasswordScreen.route) {
            ForgotPasswordScreen()
        }
    }
}