package com.example.ecommercejetpack.presentation.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Gray
import com.example.ecommercejetpack.ui.theme.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen() {

    Scaffold(containerColor = Color(0xFFF9F9F9), topBar = {
        CenterAlignedTopAppBar(
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
                    text = "Checkout", style = Typography.headlineSmall
                )
            },

            )
    }, content = { innerPadding ->

        Column(
            modifier = Modifier
                .verticalScroll(state = ScrollState(initial = 1))
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp, top = 31.dp, bottom = 13.dp)
        ) {
            Text(text = "Shipping address")
            Card(
                modifier = Modifier.padding(top = 21.dp), colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ), elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp,
                ), shape = RoundedCornerShape(size = 8.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 28.dp, vertical = 20.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 7.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Jane Doe",
                            style = Typography.displayMedium,
                        )
                        Text(
                            text = "Change",
                            style = Typography.displayMedium.copy(color = Color(0xFFDB3022))
                        )
                    }
                    Text(
                        text = "3 Newbridge Court Chino Hills, CA 91709, United States",
                        style = Typography.displayMedium.copy(fontWeight = FontWeight.Normal)
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp, top = 57.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Payment",
                    style = Typography.headlineMedium.copy(fontWeight = FontWeight.Medium),
                )
                Text(
                    text = "Change",
                    style = Typography.displayMedium.copy(color = Color(0xFFDB3022))
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 17.dp, bottom = 51.dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 17.dp)
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color(0x14000000),
                            ambientColor = Color(0x14000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(64.dp)
                        .height(38.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mastercard),
                        contentDescription = "mastercard"
                    )
                }
                Text(
                    text = "**** **** **** 3947", style = Typography.displayMedium
                )
            }
            Text(
                text = "Delivery method",
                style = Typography.headlineMedium.copy(fontWeight = FontWeight.Medium),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 52.dp, top = 21.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color(0x14000000),
                            ambientColor = Color(0x14000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(100.dp)
                        .height(72.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.fedex),
                            contentDescription = "mastercard"
                        )
                        Spacer(modifier = Modifier.height(11.dp))
                        Text(text = "2-3 days", style = Typography.labelMedium.copy(color = Gray))

                    }
                }
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color(0x14000000),
                            ambientColor = Color(0x14000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(100.dp)
                        .height(72.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.usps),
                            contentDescription = "mastercard"
                        )
                        Spacer(modifier = Modifier.height(11.dp))
                        Text(text = "2-3 days", style = Typography.labelMedium.copy(color = Gray))

                    }
                }
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color(0x14000000),
                            ambientColor = Color(0x14000000),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .width(100.dp)
                        .height(72.dp)
                        .background(
                            color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.dhl),
                            contentDescription = "mastercard"
                        )
                        Spacer(modifier = Modifier.height(11.dp))
                        Text(text = "2-3 days", style = Typography.labelMedium.copy(color = Gray))

                    }
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order:", style = Typography.displayMedium.copy(color = Gray))
                Text(
                    text = "112$", style = Typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 17.dp, bottom = 17.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Delivery:", style = Typography.displayMedium.copy(color = Gray))
                Text(
                    text = "15$", style = Typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Summary:", style = Typography.bodyLarge.copy(color = Gray))
                Text(
                    text = "112$",
                    style = Typography.headlineSmall.copy(fontWeight = FontWeight.Medium)
                )
            }
            Spacer(modifier = Modifier.height(26.dp))
            DefaultButton(text = "SUBMIT ORDER") {

            }
        }
    })
}

@Preview
@Composable
fun CheckoutScreenPreview() {
    EcommerceJetpackTheme {
        CheckoutScreen()
    }
}