package com.example.ecommercejetpack.presentation.catalog

import android.annotation.SuppressLint
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import coil.compose.AsyncImage
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.domain.model.SortFilter
import com.example.ecommercejetpack.domain.model.sortsFilter
import com.example.ecommercejetpack.presentation.common.BottomSheet
import com.example.ecommercejetpack.presentation.common.ProductItem
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Primary
import com.example.ecommercejetpack.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    var showSheet = remember { mutableStateOf(false) }
    val modalBottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()


    var sortFilterText by remember { mutableStateOf("Popular") }
    var sortFilterValue by remember { mutableStateOf(0) }


    if (showSheet.value) {
        FilterSortBottomSheet(
            showSheet = showSheet,
            modalBottomSheetState = modalBottomSheetState,
            scope = scope,
            value = sortFilterValue
        ) {
            sortFilterText = it.name
            sortFilterValue = it.value
        }
    }




    Scaffold(topBar = {
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
                    text = "Women’s tops",
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
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(modifier = Modifier.padding(top = 10.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(start = 16.dp)
                ) {
                    items(10) {
                        Text(
                            text = "T-shirts",
                            modifier = Modifier
                                .padding(end = 6.dp)
                                .background(
                                    color = Color(0xFF222222),
                                    shape = RoundedCornerShape(size = 29.dp)
                                )
                                .shadow(
                                    elevation = 4.dp,
                                    spotColor = Color(0x40000000),
                                    ambientColor = Color(0x40000000)
                                )
                                .padding(11.dp, 8.dp),
                            style = Typography.labelMedium.copy(color = Color.White),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, end = 16.dp, start = 16.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable(
                            onClick = { },
                            role = Role.Button,
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.filter_list),
                            contentDescription = "filter_list",
                        )
                        Text(
                            text = "Filters",
                            modifier = Modifier.padding(start = 6.dp),
                            style = Typography.labelMedium
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable(
                            onClick = {
                                scope.launch {
//                                    modalBottomSheetState.show()
                                    showSheet.value = true
                                }
                            },
                            role = Role.Button,
                        ),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.swap_vert),
                            contentDescription = "swap_vert"
                        )

                        Text(
                            text = sortFilterText,
                            modifier = Modifier.padding(start = 6.dp),
                            style = Typography.labelMedium
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.view_filter),
                        contentDescription = "view_filter",
                        modifier = Modifier.clickable(
                            onClick = { },
                            role = Role.Button,
                        ),
                    )
                }
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Adaptive(minSize = (screenWidth / (2.1).toFloat())),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    content = {
                        items(6) {
//                            ProductItem(percent = if (it % 2 == 0) "-20" else null)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )

            }
        }
    })
}

@Preview
@Composable
fun CatalogScreenPreview() {
    EcommerceJetpackTheme {
        CatalogScreen()
    }
}