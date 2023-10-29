package com.example.ecommercejetpack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.common.metropolisFont


@Composable
fun HomeRowText(
    headline: String,
    trailingText: String = "View all",
    subText: String,
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = headline, style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = metropolisFont,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF222222),
                )
            )
            Text(
                text = subText, style = TextStyle(
                    fontSize = 11.sp,
                    fontFamily = metropolisFont,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9B9B9B),
                )
            )
        }

        Text(
            text = trailingText, style = TextStyle(
                fontSize = 11.sp,
                fontFamily = metropolisFont,
                fontWeight = FontWeight(400),
                color = Color(0xFF222222),
            )
        )
    }

}