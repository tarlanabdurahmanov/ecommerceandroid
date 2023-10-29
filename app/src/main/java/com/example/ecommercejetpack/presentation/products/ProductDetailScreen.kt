package com.example.ecommercejetpack.presentation.products

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.BottomSheet
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.presentation.common.ProductItem
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Gray
import com.example.ecommercejetpack.ui.theme.Primary
import com.example.ecommercejetpack.ui.theme.Typography
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen() {

    var showSheet = remember { mutableStateOf(false) }
    val modalBottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val sizes = listOf("XS", "S", "M", "L", "XL")
    val selectedSize = remember { mutableStateOf("") }



    if (showSheet.value) {
        BottomSheet(
            onDismiss = { showSheet.value = false },
            sheetState = modalBottomSheetState,
        ) {
            Column {
                Text(
                    "Select size",
                    style = Typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 22.dp)
                )


                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Adaptive(minSize = 100.dp),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(16.dp),
                    content = {
                        items(sizes.size) {
                            Box(modifier = Modifier
                                .padding(end = 16.dp)
                                .border(
                                    width = 0.4.dp,
                                    color = if (selectedSize.value == sizes[it]) Primary else Color(
                                        0xFF9B9B9B
                                    ),
                                    shape = RoundedCornerShape(size = 8.dp)
                                )
                                .width(100.dp)
                                .height(40.dp)
                                .background(
                                    color = if (selectedSize.value == sizes[it]) Primary else Color(
                                        0xFFFFFFFF
                                    ), shape = RoundedCornerShape(size = 8.dp)
                                )
                                .clickable(
                                    role = Role.Button
                                ) {
                                    selectedSize.value = sizes[it]
                                }, contentAlignment = Alignment.Center, content = {
                                Text(
                                    text = sizes[it],
                                    textAlign = TextAlign.Center,
                                    style = Typography.displayMedium.copy(
                                        color = if (selectedSize.value == sizes[it]) Color.White else Color(
                                            0xFF222222
                                        ),
                                    )
                                )
                            })
                        }
                    },
                )
                DefaultButton(text = "ADD TO CART", modifier = Modifier.padding(16.dp)) {
                    scope.launch {
                        modalBottomSheetState.hide()
                        showSheet.value = false
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }


    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier.shadow(
                elevation = 8.dp, spotColor = Color(0x40D32626), ambientColor = Color(0x40D32626)
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.back), contentDescription = "back"
                    )
                }
            },
            title = {
                Text(
                    text = "Short dress",
                    style = Typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "search"
                    )
                }
            },
        )
    }, bottomBar = {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .background(color = Color.White)
                .padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            DefaultButton(text = "ADD TO CART") {

            }
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(state = ScrollState(initial = 1))
                .padding(bottom = 30.dp)
        ) {
            ImageSlider(images = listOf(R.drawable.product_detail, R.drawable.product_detail))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(contentAlignment = Alignment.CenterStart, modifier = Modifier
                    .border(
                        width = 0.4.dp,
                        color = Color(0xFF9B9B9B),
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .width(138.dp)
                    .height(40.dp)
                    .background(
                        color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                    )
                    .clickable {
                        showSheet.value = true
                    }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Size", style = Typography.displayMedium
                        )

                        Image(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "arrow_down"
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.CenterStart, modifier = Modifier
                        .border(
                            width = 0.4.dp,
                            color = Color(0xFF9B9B9B),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(138.dp)
                        .height(40.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Black", style = Typography.displayMedium
                        )

                        Image(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "arrow_down"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x14000000),
                            ambientColor = Color(0x14000000)
                        )
                        .width(36.dp)
                        .height(36.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 29.dp)
                        )
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "heart",
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 22.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "H&M", style = Typography.headlineLarge)
                    Text(
                        text = "Short black dress",
                        style = Typography.labelMedium.copy(color = Gray)
                    )
                    Row {
                        repeat(5) {
                            Image(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "star"
                            )
                        }
                        Text(
                            text = "(10)", style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 8.sp,
                                fontFamily = metropolisFont,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF9B9B9B),

                                )
                        )
                    }
                }
                Text(text = "$19.99", style = Typography.headlineLarge)
            }

            Text(
                text = "Short dress in soft cotton jersey with decorative buttons down the front and a wide, frill-trimmed square neckline with concealed elastication. Elasticated seam under the bust and short puff sleeves with a small frill trim.",
                style = Typography.displayMedium.copy(fontWeight = FontWeight.W400),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )

            Divider(
                thickness = 0.4.dp, color = Gray, modifier = Modifier.padding(top = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Shipping info",
                    style = Typography.bodyLarge.copy(fontWeight = FontWeight.W400)
                )
                Text(
                    text = ">", style = Typography.bodyLarge.copy(fontWeight = FontWeight.W400)
                )
            }
            Divider(
                thickness = 0.4.dp, color = Gray
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Support",
                    style = Typography.bodyLarge.copy(fontWeight = FontWeight.W400)
                )
                Text(
                    text = ">", style = Typography.bodyLarge.copy(fontWeight = FontWeight.W400)
                )
            }
            Divider(
                thickness = 0.4.dp, color = Gray
            )

            Text(
                text = "You can also like this",
                style = Typography.headlineSmall,
                modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 12.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(5) {
                    ProductItem(percent = "-20")
                }
            }

        }
    }

}


@Preview
@Composable
fun ProductDetailScreenPreview() {
    EcommerceJetpackTheme {
        ProductDetailScreen()
    }

}

@Composable
fun ImageSlider(images: List<Any>) {
    var currentImageIndex by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        itemsIndexed(images) { index, image ->
            Image(painter = painterResource(id = image as Int),
                contentDescription = "product_detail2",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(413.dp)
                    .width(275.dp)
                    .clickable {
                        if (index != currentImageIndex && !isAnimating) {
                            isAnimating = true
                            coroutineScope.launch {
                                val delayMillis = 500L
                                delay(delayMillis / 2)
                                currentImageIndex = index
                                delay(delayMillis)
                                isAnimating = false
                            }
                        }
                    })
        }
    }

}
