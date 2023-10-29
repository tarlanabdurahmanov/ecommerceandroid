package com.example.ecommercejetpack.presentation.catalog


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecommercejetpack.domain.model.SortFilter
import com.example.ecommercejetpack.domain.model.sortsFilter
import com.example.ecommercejetpack.presentation.common.BottomSheet
import com.example.ecommercejetpack.ui.theme.Primary
import com.example.ecommercejetpack.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSortBottomSheet(
    showSheet: MutableState<Boolean>,
    modalBottomSheetState: SheetState,
    scope: CoroutineScope,
    value: Int,
    onSubmit: (SortFilter) -> Unit,
) {
    BottomSheet(
        onDismiss = { showSheet.value = false },
        sheetState = modalBottomSheetState,
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Sort By",
                style = Typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.4f)
                    .padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                items(sortsFilter.size) {
                    Text(
                        text = sortsFilter[it].name,
                        style = Typography.bodyLarge.copy(
                            color = if (sortsFilter[it].value == value) Color.White else Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = if (sortsFilter[it].value == value) Primary else Color.Transparent)
                            .align(alignment = Alignment.Start)
                            .clickable {
                                onSubmit(sortsFilter[it])
                                scope.launch {
                                    modalBottomSheetState.hide()
                                    showSheet.value = false
                                }
                            }
                            .padding(start = 16.dp, bottom = 16.dp, top = 16.dp),
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }
    }
}