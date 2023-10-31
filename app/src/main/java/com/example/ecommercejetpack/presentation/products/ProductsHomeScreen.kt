package com.example.ecommercejetpack.presentation.products

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommercejetpack.presentation.bottomnavigation.BottomItem
import com.example.ecommercejetpack.presentation.bottomnavigation.BottomNavigation
import com.example.ecommercejetpack.presentation.bottomnavigation.bottomNavGraph
import com.example.ecommercejetpack.presentation.catalog.CatalogScreen
import com.example.ecommercejetpack.presentation.category.CategoryScreen
import com.example.ecommercejetpack.presentation.checkout.CheckoutScreen
import com.example.ecommercejetpack.presentation.filters.FiltersScreen
import com.example.ecommercejetpack.presentation.graphs.bottom.BottomNavigationRoutes
import com.example.ecommercejetpack.presentation.home.HomeScreen
import com.example.ecommercejetpack.presentation.mybag.MyBagScreen


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductsHomeScreen(
    navController: NavController,
) {
    val navControllerBottom = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        BottomNavigation(navController = navControllerBottom)
    }) { paddingValues ->
        NavHost(
            navController = navControllerBottom,
            startDestination = BottomNavigationRoutes.HomeScreen.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            bottomNavGraph(navController)
        }

    }
}


