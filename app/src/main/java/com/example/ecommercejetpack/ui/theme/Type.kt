package com.example.ecommercejetpack.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.common.metropolisFont

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = Color(0xFF222222),
    ),
    headlineMedium = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color(0xFF222222),
    ),
    headlineSmall = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Color(0xFF222222),
    ),
    bodyLarge = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color(0xFF222222),
    ),
    titleLarge = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        color = Color(0xFF222222),
    ),
    displayMedium = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF222222),
    ),
    labelMedium = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        color = Color(0xFF222222),
    ),
)