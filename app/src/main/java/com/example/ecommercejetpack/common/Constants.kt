package com.example.ecommercejetpack.common

import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.ecommercejetpack.R
import org.w3c.dom.Text

object Constants {
    const val BASE_URL = "http://192.168.100.3:8000/api/"


    //shared pref
    const val AUTH_TOKEN = "token"
    const val USER = "user"

    //token
    const val BEARER = "Bearer "
}


val metropolisFont = FontFamily(
    Font(R.font.metropolis_regular, FontWeight.Normal),
    Font(R.font.metropolis_medium, FontWeight.Medium),
    Font(R.font.metropolis_bold, FontWeight.Bold),
)


