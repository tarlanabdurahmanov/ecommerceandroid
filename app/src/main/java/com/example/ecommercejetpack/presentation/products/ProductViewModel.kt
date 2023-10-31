package com.example.ecommercejetpack.presentation.products

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.domain.use_case.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> get() = _state

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getProducts() {
        productUseCase().onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = ProductState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    _state.value = ProductState(data = result.data)
                }

                is NetworkResponse.Error -> {
                    _state.value = ProductState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }


}