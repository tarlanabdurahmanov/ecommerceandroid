package com.example.ecommercejetpack.presentation.bottomnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.ui.theme.Gray
import com.example.ecommercejetpack.ui.theme.Primary


@Composable
fun BottomNavigation(
    navController: NavController,
) {
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    val listItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.ShoppingScreen,
        BottomItem.BagScreen,
        BottomItem.FavouritesScreen,
        BottomItem.UserScreen,
    )
    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        modifier = Modifier
            .height(83.dp)
            .background(
                color = Color(0xFFFFFFFF), shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                )
            )
    ) {
        listItems.forEachIndexed { index, navigationItem ->
            NavigationBarItem(colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White,
            ), selected = index == navigationSelectedItem, label = {
                Text(
                    navigationItem.title, style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = metropolisFont,
                        fontWeight = FontWeight.W500,
                        color = if (index == navigationSelectedItem) Primary else Gray,
                    )
                )
            }, icon = {
                Image(
                    painter = painterResource(id = if (index == navigationSelectedItem) navigationItem.activeIcon else navigationItem.icon),
                    contentDescription = navigationItem.title
                )
            }, onClick = {
                navigationSelectedItem = index
                navController.navigate(navigationItem.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })
        }
    }

}