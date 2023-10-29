package com.example.ecommercejetpack.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.common.metropolisFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    value: String,
    onValueChange: (String) -> Unit,
    focus: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    text: String,
    keyboardType: KeyboardType,
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 8.dp, spotColor = Color(0x0D000000), ambientColor = Color(0x0D000000)
            )
            .border(
                width = 1.dp,
                color = if (isError.value) Color(0xFFF01F0E) else Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 4.dp)
            )
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
    ) {

        TextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = text, style = TextStyle(
                        fontFamily = metropolisFont,
                        fontSize = if (focus.value || value.isNotEmpty()) 11.sp else 14.sp,
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
            singleLine = true,
            trailingIcon = {
                if (isError.value) IconButton(onClick = {
                    onValueChange("")
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = "delete"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .onFocusChanged {
                    if (focus.value != it.isFocused) {
                        focus.value = it.isFocused
                    }
                },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
            ),
            shape = RoundedCornerShape(size = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            ),
            maxLines = 1,
        )
    }

}
