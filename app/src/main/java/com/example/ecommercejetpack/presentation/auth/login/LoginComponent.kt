package com.example.ecommercejetpack.presentation.auth.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.presentation.graphs.auth.AuthRoutes
import com.example.ecommercejetpack.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginComponent(
    navController: NavController,
    isLoading: Boolean, onSignInClick: (email: String, password: String, checkBox: Boolean) -> Unit,
) {
    var email by rememberSaveable { mutableStateOf("mail@gmail.com") }
    var password by rememberSaveable { mutableStateOf("12345678") }
    var checkBox by rememberSaveable { mutableStateOf(false) }


    val focusEmail = remember { mutableStateOf(false) }
    val focusPassword = remember { mutableStateOf(false) }


    Column {
        TextField(value = email, onValueChange = { newEmail ->
            email = newEmail
        }, label = {
            Text(
                text = "Email", style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = if (focusEmail.value || email.isNotEmpty()) 11.sp else 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9B9B9B),

                    )
            )
        }, textStyle = TextStyle(
            fontFamily = metropolisFont,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF2D2D2D),

            ), modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .shadow(
                elevation = 8.dp, spotColor = Color(0x0D000000), ambientColor = Color(0x0D000000)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
            .onFocusChanged {
                if (focusEmail.value != it.isFocused) {
                    focusEmail.value = it.isFocused
                }
            }, keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
        ), shape = RoundedCornerShape(size = 8.dp), colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = Color.Transparent
        )
        )



        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = { newPass ->
            password = newPass
        }, label = {
            Text(
                text = "Password", style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = if (focusPassword.value || password.isNotEmpty()) 11.sp else 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9B9B9B),

                    )
            )
        }, textStyle = TextStyle(
            fontFamily = metropolisFont,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF2D2D2D),

            ), modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .shadow(
                elevation = 8.dp, spotColor = Color(0x0D000000), ambientColor = Color(0x0D000000)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
            .onFocusChanged {
                if (focusPassword.value != it.isFocused) {
                    focusPassword.value = it.isFocused
                }
            }, keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
        ), shape = RoundedCornerShape(size = 8.dp), colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = Color.Transparent
        )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = "Forgot your password?", style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF222222),

                    textAlign = TextAlign.Right,
                )
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "arrow_right"
            )
        }

        DefaultButton(text = "LOGIN", isLoading = isLoading, onClick = {
            onSignInClick(email, password, checkBox)
        })

        Text(text = "Don't have an account ? Register", style = TextStyle(
            fontFamily = metropolisFont,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF222222),
            textAlign = TextAlign.Center,
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .clickable {
                navController.navigate(AuthRoutes.SignUpScreen.route)
            })

    }
}
