package com.example.ecommercejetpack.presentation.filters

import android.annotation.SuppressLint
import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.MutableLiveData
import coil.compose.AsyncImage
import com.example.ecommercejetpack.R
import com.example.ecommercejetpack.domain.model.SortFilter
import com.example.ecommercejetpack.domain.model.sortsFilter
import com.example.ecommercejetpack.presentation.common.BottomSheet
import com.example.ecommercejetpack.presentation.common.DefaultButton
import com.example.ecommercejetpack.presentation.common.ProductItem
import com.example.ecommercejetpack.ui.theme.EcommerceJetpackTheme
import com.example.ecommercejetpack.ui.theme.Gray
import com.example.ecommercejetpack.ui.theme.Primary
import com.example.ecommercejetpack.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FiltersScreen() {

    var sliderPosition by remember { mutableStateOf(0f..1000f) }

    val colors = listOf("#FF0000", "#00FF00", "#0000FF")
    val selectedColors = remember { mutableStateListOf<String>() }

    val sizes = listOf("XS", "S", "M", "L", "XL")
    val selectedSizes = remember { mutableStateListOf<String>() }

    val categories = listOf(
        mapOf(0 to "All"),
        mapOf(1 to "Women"),
        mapOf(2 to "Men"),
        mapOf(3 to "Boys"),
        mapOf(4 to "Girls"),
    )
    val selectedCategories = remember { mutableStateMapOf<Int, String>() }





    Scaffold(containerColor = Color(0xFFF9F9F9), topBar = {
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
                    text = "Filters",
                    style = Typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {

                }
            },

            )
    }, bottomBar = {
        Row(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0x1A000000)
                )
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
                .padding(bottom = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultButton(text = "Discard", modifier = Modifier.weight(1f)) {

            }
            Spacer(modifier = Modifier.width(23.dp))
            DefaultButton(text = "Apply", modifier = Modifier.weight(1f)) {

            }
        }
    }, content = { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = "Price range",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 14.dp)
            )

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .shadow(
                        elevation = 8.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$" + sliderPosition.start.toInt().toString(),
                        style = Typography.displayMedium
                    )
                    Text(
                        text = "$" + sliderPosition.endInclusive.toInt().toString(),
                        style = Typography.displayMedium
                    )
                }
                RangeSlider(
                    value = sliderPosition,
                    steps = 10,
                    colors = SliderDefaults.colors(
                        thumbColor = Primary,
                        activeTrackColor = Primary,
                        inactiveTrackColor = Gray,

                        ),

                    onValueChange = { range -> sliderPosition = range },
                    valueRange = 0f..100f,

                    onValueChangeFinished = {
                        // launch some business logic update with the state you hold
                        // viewModel.updateSelectedSliderValue(sliderPosition)
                    },
                )
            }

            Text(
                text = "Colors",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 14.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .shadow(
                        elevation = 8.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 50.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    userScrollEnabled = false,
                ) {
                    items(colors.size) {
                        Box(
                            modifier = Modifier
                                .requiredSize(50.dp)
                                .clip(shape = CircleShape)
                                .border(
                                    border = if (selectedColors.contains(colors[it])) BorderStroke(
                                        2.dp, Primary
                                    )
                                    else BorderStroke(
                                        0.dp, Color.Transparent
                                    ), shape = CircleShape
                                ), contentAlignment = Alignment.Center

                        ) {
                            Button(onClick = {
                                if (selectedColors.contains(colors[it])) {
                                    selectedColors.remove(colors[it])
                                } else {
                                    selectedColors.add(colors[it])
                                }

                            },
                                shape = CircleShape,
                                modifier = Modifier.requiredSize(40.dp),
                                contentPadding = PaddingValues(1.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(colors[it].toColorInt())
                                ),
                                content = {})
                        }

                    }
                }

            }
            Text(
                text = "Sizes",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 14.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .shadow(
                        elevation = 8.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                LazyRow(userScrollEnabled = false) {
                    items(sizes.size) {
                        Box(modifier = Modifier
                            .padding(end = 16.dp)
                            .border(
                                width = 0.4.dp,
                                color = if (selectedSizes.contains(sizes[it])) Primary else Color(
                                    0xFF9B9B9B
                                ),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .width(40.dp)
                            .height(40.dp)
                            .background(
                                color = if (selectedSizes.contains(sizes[it])) Primary else Color(
                                    0xFFFFFFFF
                                ), shape = RoundedCornerShape(size = 8.dp)
                            )
                            .clickable(
                                role = Role.Button
                            ) {
                                if (selectedSizes.contains(sizes[it])) {
                                    selectedSizes.remove(sizes[it])
                                } else {
                                    selectedSizes.add(sizes[it])
                                }
                            }, contentAlignment = Alignment.Center, content = {
                            Text(
                                text = sizes[it],
                                textAlign = TextAlign.Center,
                                style = Typography.displayMedium.copy(
                                    color = if (selectedSizes.contains(sizes[it])) Color.White else Color(
                                        0xFF222222
                                    ),
                                )
                            )
                        })
                    }

                }

            }
            Text(
                text = "Category",
                style = Typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 14.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .shadow(
                        elevation = 8.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 100.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    userScrollEnabled = false
                ) {
                    items(categories.size) {
                        Box(modifier = Modifier
                            .padding(end = 16.dp)
                            .border(
                                width = 0.4.dp,
                                color = if (selectedCategories.containsValue(categories[it].values.first())) Primary else Color(
                                    0xFF9B9B9B
                                ),
                                shape = RoundedCornerShape(size = 8.dp)
                            )
                            .width(40.dp)
                            .height(40.dp)
                            .background(
                                color = if (selectedCategories.containsValue(categories[it].values.first())) Primary else Color(
                                    0xFFFFFFFF
                                ), shape = RoundedCornerShape(size = 8.dp)
                            )
                            .clickable(
                                role = Role.Button
                            ) {
                                if ((selectedCategories.containsValue(categories[it].values.first()))) {
                                    selectedCategories.remove(categories[it].keys.first())
                                } else {
                                    selectedCategories += categories[it]
                                }
                            }, contentAlignment = Alignment.Center, content = {
                            Text(
                                text = categories[it].values.first().toString(),
                                textAlign = TextAlign.Center,
                                style = Typography.displayMedium.copy(
                                    color = if (selectedCategories.containsValue(categories[it].values.first())) Color.White else Color(
                                        0xFF222222
                                    ),
                                )
                            )
                        })

                    }
                }

            }
        }
    })
}

@Preview
@Composable
fun FiltersScreenPreview() {
    FiltersScreen()
}