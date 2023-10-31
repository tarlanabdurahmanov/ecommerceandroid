package com.example.ecommercejetpack.presentation.products

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.data.remote.dto.ProductDetailDto
import com.example.ecommercejetpack.domain.use_case.ProductDetailUseCase
import com.example.ecommercejetpack.domain.use_case.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    private val productDetailUseCase: ProductDetailUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> get() = _state

    private val _stateDetail = MutableStateFlow(ProductDetailState())
    val stateDetail: StateFlow<ProductDetailState> get() = _stateDetail

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

    fun productDetail(productId: Int) {
        val body = ProductDetailDto(productId);
        productDetailUseCase(body).onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _stateDetail.value = ProductDetailState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    _stateDetail.value = ProductDetailState(data = result.data)
                }

                is NetworkResponse.Error -> {
                    _stateDetail.value = ProductDetailState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }


}