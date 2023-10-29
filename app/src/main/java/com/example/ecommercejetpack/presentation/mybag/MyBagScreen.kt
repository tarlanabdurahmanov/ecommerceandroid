package com.example.ecommercejetpack.presentation.mybag

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.presentation.home.HomeRowText
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Gray
import com.example.ecommercejetpack.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBagScreen() {
    var expanded by remember { mutableStateOf(false) }

    Scaffold(containerColor = Color.White, topBar = {
        TopAppBar(
            title = {},
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "search"
                    )
                }
            },
        )
    }) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            DefaultButton(text = "CHECK OUT", modifier = Modifier.padding(16.dp)) {

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(
                    text = "My Bag", style = TextStyle(
                        fontSize = 34.sp,
                        fontFamily = metropolisFont,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF222222),
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color(0x14000000),
                        )
                        .fillMaxWidth()
                        .height(104.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        )
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.mybag1),
                        contentDescription = "my-bag1",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(104.dp)
                            .width(104.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    bottomStart = 8.dp,
                                    topStart = 8.dp,
                                ),
                            )
                    )
                    Column(
                        modifier = Modifier.padding(
                            start = 11.dp, top = 11.dp, bottom = 11.dp
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Pullover",
                                    style = Typography.headlineMedium.copy(fontWeight = FontWeight.Medium),
                                )

                                Row {
                                    Text(
                                        text = "Color: Black", style = TextStyle(
                                            fontSize = 11.sp,
                                            fontFamily = metropolisFont,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF9B9B9B),
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(13.dp))
                                    Text(
                                        text = "Size: L", style = TextStyle(
                                            fontSize = 11.sp,
                                            fontFamily = metropolisFont,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xFF9B9B9B),
                                        )
                                    )
                                }
                            }
                            Box {
                                IconButton(onClick = { expanded = !expanded }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vertical_dots),
                                        contentDescription = "vertical_dots",
                                    )
                                }
                                DropdownMenu(modifier = Modifier
                                    .shadow(
                                        elevation = 8.dp,
                                        spotColor = Color(0x24000000),
                                        ambientColor = Color(0x24000000),
                                        shape = RoundedCornerShape(size = 10.dp)
                                    )
                                    .background(
                                        color = Color(0xFFFFFFFF),
                                        shape = RoundedCornerShape(size = 8.dp)
                                    ),
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }) {
                                    DropdownMenuItem(
                                        text = {
                                            Text(
                                                text = "Add to favorites",
                                                style = Typography.labelMedium,
                                            )
                                        },
                                        onClick = { /*TODO*/ },
                                    )
                                    DropdownMenuItem(text = {
                                        Text(
                                            text = "Delete from the list",
                                            style = Typography.labelMedium,
                                        )
                                    }, onClick = { /*TODO*/ })
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 8.dp,
                                            spotColor = Color(0x1A000000),
                                            shape = RoundedCornerShape(29.dp)
                                        )
                                        .width(36.dp)
                                        .height(36.dp)
                                        .background(
                                            color = Color(0xFFFFFFFF),
                                            shape = RoundedCornerShape(size = 29.dp)
                                        )

                                        .padding(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.minus),
                                        contentDescription = "heart",
                                        modifier = Modifier
                                            .width(24.dp)
                                            .height(24.dp)
                                    )
                                }
                                Text(
                                    text = "1",
                                    style = Typography.displayMedium,
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .shadow(
                                            elevation = 8.dp,
                                            spotColor = Color(0x1A000000),
                                            shape = RoundedCornerShape(29.dp)
                                        )
                                        .width(36.dp)
                                        .height(36.dp)
                                        .background(
                                            color = Color(0xFFFFFFFF),
                                            shape = RoundedCornerShape(size = 29.dp)
                                        )
                                        .padding(10.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.plus),
                                        contentDescription = "heart",
                                        modifier = Modifier
                                            .width(24.dp)
                                            .height(24.dp)
                                    )
                                }
                            }
                            Text(
                                text = "51$",
                                style = Typography.displayMedium,
                                textAlign = TextAlign.Right,
                                modifier = Modifier.padding(end = 16.dp)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total amount:",
                        style = Typography.displayMedium.copy(color = Gray),
                    )

                    Text(
                        text = "124$",
                        style = Typography.headlineSmall,
                        textAlign = TextAlign.Right,
                    )
                }
            }

        }
    }
}


@Preview
@Composable
fun MyBagScreenPreview() {
    EcommerceJetpackTheme {
        MyBagScreen()
    }
}