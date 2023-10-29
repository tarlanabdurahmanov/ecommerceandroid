package com.example.ecommercejetpack.presentation.auth.register


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.domain.model.AuthModel
import com.example.ecommercejetpack.presentation.common.Toast


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.ecommercejetpack.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel(),
    loading: (Boolean) -> Unit,
    signUpSuccess: () -> Unit,
) {

    val state: State<RegisterState> = viewModel.state
    val data: AuthModel? = state.value.data


    //error message
    if (!state.value.errorMessage.isNullOrEmpty()) {
        Toast(message = state.value.errorMessage ?: "Something went wrong")
    }

    //signUp successful
    if (data != null) {
        LaunchedEffect(Unit) {
            signUpSuccess()
        }
        Toast(message = state.value.data!!.message!!)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    //component
    Scaffold(contentColor = Color(0xFFF9F9F9), topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.back), contentDescription = "back"
                    )
                }
            },
            title = { /*TODO*/ },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFF9F9F9),
            ),
        )
    }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 14.dp, end = 14.dp, bottom = 14.dp)
                .verticalScroll(state = rememberScrollState())

        ) {
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Sign up", style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = 34.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF222222),

                    )
            )

            Spacer(modifier = Modifier.height(73.dp))


            //sign in component
            RegisterComponent(
                isLoading = state.value.isLoading,
                onSignUpClick = { name, email, password ->
                    viewModel.register(name, email, password)
                })

            Spacer(modifier = Modifier.requiredHeight(height = 80.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Or login with social account",
// 14px
                    style = TextStyle(
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

//    progressbar
//            if (state.value.isLoading) {
//                LoadingProgress()
//                loading(true)
//            } else {
//                loading(false)
//            }

            }
        }
    }
}