package com.example.ecommercejetpack.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont

@Composable
fun ProductItem(
    percent: String? = null,
) {
    Column(
        modifier = Modifier.padding(21.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd,
        ) {
            Box() {

                Image(
                    painter = painterResource(id = R.drawable.product1),
                    contentDescription = "product1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(184.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),

                    )
                Text(
                    text = if (percent != null) "$percent% " else "NEW",
                    modifier = Modifier
                        .padding(10.dp, 8.dp)
                        .background(
                            color = Color(if (percent != null) 0xFFDB3022 else 0xFF222222),
                            shape = RoundedCornerShape(size = 29.dp)
                        )
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .padding(6.dp),
                    style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = metropolisFont,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    )
                )
            }

            Box(
                modifier = Modifier
                    .offset(y = 15.dp)
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
        Row(modifier = Modifier.padding(top = 4.dp, bottom = 3.dp)) {
            repeat(5) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
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
        Text(
            text = "Dorothy Perkins", style = TextStyle(
                fontSize = 11.sp,
                fontFamily = metropolisFont,
                fontWeight = FontWeight(400),
                color = Color(0xFF9B9B9B),

                )
        )
        Text(
            text = "Evening Dress", modifier = Modifier.padding(bottom = 1.dp), style = TextStyle(
                fontSize = 16.sp,
                fontFamily = metropolisFont,
                fontWeight = FontWeight(400),
                color = Color(0xFF222222),

                )
        )
        Row {
            Text(
                text = "15$", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = metropolisFont,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF9B9B9B),

                    )
            )
            Text(
                text = "12$", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = metropolisFont,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFDB3022),

                    )
            )
        }
    }
}