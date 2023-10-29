package com.example.ecommercejetpack.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.ProductItem
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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

            HomeRowText(headline = "Sale", subText = "Super summer sale")

            LazyRow {
                items(5) {
                    ProductItem(percent = "-20")
                }
            }


            HomeRowText(headline = "New", subText = "You’ve never seen it before!")

            LazyRow {
                items(5) {
                    ProductItem()
                }
            }


        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    EcommerceJetpackTheme {
        HomeScreen()
    }
}