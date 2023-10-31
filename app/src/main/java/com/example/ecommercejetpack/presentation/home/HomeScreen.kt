package com.example.ecommercejetpack.presentation.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.domain.model.ProductModel
import com.example.ecommercejetpack.presentation.common.LoadingProgress
import com.example.ecommercejetpack.presentation.common.ProductItem
import com.example.ecommercejetpack.presentation.graphs.products.ProductsRoutes
import com.example.ecommercejetpack.presentation.products.ProductState
import com.example.ecommercejetpack.presentation.products.ProductViewModel
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    val state: ProductState by viewModel.state.collectAsState()
    val data: ProductModel? = state.data

    LaunchedEffect(Unit) {
        if (data?.products == null) {
            viewModel.getProducts()
        }
    }

    Scaffold {
        Column(modifier = Modifier.verticalScroll(state = ScrollState(initial = 1))) {
            Box(
                modifier = Modifier
                    .height(260.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_image2),
                    contentDescription = "main_image2",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                )
                Text(
                    text = "Street clothes",
                    modifier = Modifier.padding(bottom = 48.dp, start = 21.dp),
                    style = TextStyle(
                        fontSize = 34.sp,
                        fontFamily = metropolisFont,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),

                        )
                )
            }



            if (!state.isLoading) {
                HomeRowText(headline = "Sale", subText = "Super summer sale")
                LazyRow {
                    data?.products?.let { products ->
                        items(products) { product ->
                            ProductItem(product = product, onClick = { id ->
                                navController.navigate(
                                    ProductsRoutes.ProductDetailScreen.route.replace(
                                        oldValue = "{productId}", newValue = id.toString()
                                    )
                                )
                            })
                        }
                    }
                }
                HomeRowText(headline = "New", subText = "You’ve never seen it before!")
                LazyRow {
                    data?.products?.let { products ->
                        items(products) { product ->
                            ProductItem(product = product, onClick = { id ->
                                navController.navigate(
                                    ProductsRoutes.ProductDetailScreen.route.replace(
                                        oldValue = "{productId}", newValue = id.toString()
                                    )
                                )
                            })
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }


        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    EcommerceJetpackTheme {}
}