package com.example.ecommercejetpack.presentation.mybag

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.data.remote.dto.ProductCartDto
import com.example.ecommercejetpack.domain.model.Cart
import com.example.ecommercejetpack.domain.use_case.AddEditProductCartUseCase
import com.example.ecommercejetpack.domain.use_case.ProductCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MyBagViewModel @Inject constructor(
    private val productCartUseCase: ProductCartUseCase,
    private val addEditProductCartUseCase: AddEditProductCartUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MyBagState())
    val state: StateFlow<MyBagState> get() = _state

    val totalAmount = MutableStateFlow(0.0)


    init {
        getProductCarts()
    }

    fun getProductCarts() {
        productCartUseCase().onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = MyBagState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    _state.value = MyBagState(data = result.data)
                    totalAmount.value = 0.0
                    result.data?.carts?.map {
                        totalAmount.value += it.price!!
                    }
                }

                is NetworkResponse.Error -> {
                    _state.value = MyBagState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun addEditProductCarts(productCartDto: ProductCartDto) {
        addEditProductCartUseCase(productCartDto = productCartDto).onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = MyBagState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    getProductCarts()
                }

                is NetworkResponse.Error -> {
                    _state.value = MyBagState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}