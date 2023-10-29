package com.example.ecommercejetpack.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.common.metropolisFont
import com.example.ecommercejetpack.ui.theme.Primary


@Composable
fun DefaultButton(
    text: String,
    isLoading: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,

    ) {
    Button(
        enabled = !isLoading,
        onClick = onClick,
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                spotColor = Color(0x40D32626),
                shape = RoundedCornerShape(size = 25.dp)
            )
            .height(50.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            disabledContainerColor = Primary.copy(alpha = 0.9f),
        ),
//        elevation = ButtonDefaults.buttonElevation(
//            defaultElevation = 8.dp,
//        ),

    ) {
        if (!isLoading) {
            Text(
                text = text, style = TextStyle(
                    fontFamily = metropolisFont,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                )
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                strokeWidth = 3.dp,
                color = Color.White
            )
        }
    }
}