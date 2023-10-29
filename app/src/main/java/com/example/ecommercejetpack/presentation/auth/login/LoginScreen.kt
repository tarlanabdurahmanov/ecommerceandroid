package com.example.ecommercejetpack.presentation.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.domain.model.AuthModel
import com.example.ecommercejetpack.presentation.common.LoadingProgress
import com.example.ecommercejetpack.presentation.common.Toast


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController,
    loading: (Boolean) -> Unit,
    signInSuccess: () -> Unit,
) {
    val state: LoginState by viewModel.state.collectAsState()
    val data: AuthModel? = state.data

    //error message
    if (!state.errorMessage.isNullOrEmpty()) {
        Toast(message = state.errorMessage!!)
    }

    if (data != null) {
        LaunchedEffect(Unit) {
            signInSuccess()
        }
        Toast(message = data.message ?: "Something went wrong")
    }

    //component
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
        ) {
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Login", style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = 34.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF222222),

                    )
            )

            Spacer(modifier = Modifier.height(73.dp))

            //sign in component
            LoginComponent(isLoading = state.isLoading,
                navController = navController,
                onSignInClick = { email, password, isChecked ->
                    viewModel.login(email, password, isChecked)
                })
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.58f))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Or login with social account", style = TextStyle(
                        fontFamily = metropolisFont,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF222222),
                        textAlign = TextAlign.Center,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(modifier = Modifier
                        .shadow(
                            elevation = 8.dp,
                            spotColor = Color(0x0D000000),
                            ambientColor = Color(0x0D000000)
                        )
                        .width(92.dp)
                        .height(64.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF),
                    ), shape = RoundedCornerShape(size = 24.dp), onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "google"
                        )

                    }
                    Button(modifier = Modifier
                        .shadow(
                            elevation = 8.dp,
                            spotColor = Color(0x0D000000),
                            ambientColor = Color(0x0D000000)
                        )
                        .width(92.dp)
                        .height(64.dp), colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFFFF),
                    ), shape = RoundedCornerShape(size = 24.dp), onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            contentDescription = "facebook",

                            )

                    }
                }
            }
        }
        if (state.isLoading) {
            LoadingProgress()
            loading(true)
        } else {
            loading(false)
        }
    }


}
