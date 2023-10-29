package com.example.ecommercejetpack.presentation.category

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Typography


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen() {
    Scaffold(contentColor = Color.White, topBar = {
        TopAppBar(
            modifier = Modifier.shadow(
                elevation = 8.dp, spotColor = Color(0x40D32626), ambientColor = Color(0x40D32626)
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.back), contentDescription = "back"
                    )
                }
            },
            title = {
                Text(
                    text = "Categories",
                    style = Typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "search"
                    )
                }
            },
        )
    }, content = { innerPadding ->
        Column {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(end = 16.dp, start = 16.dp),
            ) {
                Spacer(modifier = Modifier.height(21.dp))
                DefaultButton(text = "VIEW ALL ITEMS") {

                }
                Text(
                    text = "Choose category",
                    style = Typography.displayMedium.copy(color = Color(0xFF9B9B9B)),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                )
            }
            LazyColumn() {
                items(100) {
                    Column {
                        Text(
                            text = "Tops",
                            style = Typography.bodyLarge,
                            modifier = Modifier.padding(start = 40.dp, bottom = 15.dp, top = 15.dp),
                        )
                        Divider(
                            color = Color(0xFF9B9B9B),
                            modifier = Modifier
                                .height(0.4.dp)
                                .fillMaxWidth()
                        )
                    }

                }
            }
        }
    })
}

@Preview
@Composable
fun CategoryScreenPreview() {
    EcommerceJetpackTheme {
        CategoryScreen()
    }
}