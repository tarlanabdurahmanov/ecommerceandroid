package com.example.ecommercejetpack.presentation.auth.forgotpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.presentation.common.DefaultTextField
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen() {

    var email by rememberSaveable { mutableStateOf("") }
    val focusEmail = remember { mutableStateOf(false) }
    val isError = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "Forgot password", style = TextStyle(
                fontFamily = metropolisFont,
                fontSize = 34.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF222222),
            )
        )
        Spacer(modifier = Modifier.height(87.dp))
        Text(
            text = "Please, enter your email address. You will receive a link to create a new password via email.",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = metropolisFont,
                fontWeight = FontWeight(500),
                color = Color(0xFF222222),
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            DefaultTextField(
                value = email,
                onValueChange = {
                    email = it
                    if (isError.value) {
                        isError.value = false
                    }
                },
                isError = isError,
                focus = focusEmail,
                text = "Email",
                keyboardType = KeyboardType.Email
            )
            if (isError.value) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Not a valid email address. Should be $email", style = TextStyle(
                        fontSize = 11.sp,
                        fontFamily = metropolisFont,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFF01F0E),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(55.dp))
        DefaultButton(text = "SEND", isLoading = false) {
            isError.value = true
        }
    }
}

@Preview
@Composable
fun ForgotPasswordScreenPreview() {
    EcommerceJetpackTheme(dynamicColor = false, darkTheme = false) {
        ForgotPasswordScreen()
    }
}

