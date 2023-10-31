package com.example.ecommercejetpack.presentation.auth.register


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterComponent(
    isLoading: Boolean, onSignUpClick: (name: String, email: String, password: String) -> Unit
) {
    var email by rememberSaveable { mutableStateOf("tarlan@gmail.com") }
    var password by rememberSaveable { mutableStateOf("12345678") }
    var name by rememberSaveable { mutableStateOf("tarlan") }


    val focusName = remember { mutableStateOf(false) }
    val focusEmail = remember { mutableStateOf(false) }
    val focusPassword = remember { mutableStateOf(false) }

    Column {
        TextField(
            value = name,
            onValueChange = { newName ->
                name = newName
            },
            label = {
                Text(
                    text = "Name", style = TextStyle(
                        fontFamily = metropolisFont,
                        fontSize = if (focusName.value || name.isNotEmpty()) 11.sp else 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9B9B),

                        )
                )
            },
            textStyle = TextStyle(
                fontFamily = metropolisFont,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF2D2D2D),

                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x0D000000),
                    ambientColor = Color(0x0D000000)
                )
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
                .onFocusChanged {
                    if (focusName.value != it.isFocused) {
                        focusName.value = it.isFocused
                    }
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
            ),
            shape = RoundedCornerShape(size = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = email,
            onValueChange = { newEmail ->
                email = newEmail
            },
            label = {
                Text(
                    text = "Email", style = TextStyle(
                        fontFamily = metropolisFont,
                        fontSize = if (focusEmail.value || email.isNotEmpty()) 11.sp else 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9B9B),

                        )
                )
            },
            textStyle = TextStyle(
                fontFamily = metropolisFont,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF2D2D2D),

                ),
            trailingIcon = { Icons.Default.Email },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x0D000000),
                    ambientColor = Color(0x0D000000)
                )
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
                .onFocusChanged {
                    if (focusEmail.value != it.isFocused) {
                        focusEmail.value = it.isFocused
                    }
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
            ),
            shape = RoundedCornerShape(size = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            onValueChange = { newPass ->
                password = newPass
            },
            value = password,
            label = {
                Text(
                    text = "Password", style = TextStyle(
                        fontFamily = metropolisFont,
                        fontSize = if (focusPassword.value || password.isNotEmpty()) 11.sp else 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9B9B),

                        )
                )
            },
            textStyle = TextStyle(
                fontFamily = metropolisFont,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF2D2D2D),

                ),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x0D000000),
                    ambientColor = Color(0x0D000000)
                )
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
                .onFocusChanged {
                    if (focusEmail.value != it.isFocused) {
                        focusEmail.value = it.isFocused
                    }
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
            ),
            shape = RoundedCornerShape(size = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation(),

            )


        Spacer(modifier = Modifier.height(25.dp))



        DefaultButton(text = "SIGN UP", isLoading = isLoading, onClick = {
            onSignUpClick(name, email, password)
        })

    }
}