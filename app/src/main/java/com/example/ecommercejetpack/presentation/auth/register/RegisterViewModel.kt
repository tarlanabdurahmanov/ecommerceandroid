package com.example.ecommercejetpack.presentation.auth.register


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.common.Preferences
import com.example.ecommercejetpack.data.remote.dto.RegisterDto
import com.example.ecommercejetpack.domain.use_case.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val signUpUseCase: RegisterUseCase,
    private val preferences: Preferences
) : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    fun register(name: String, email: String, password: String) {
        val body = RegisterDto(name, email, password);
        signUpUseCase(body).onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = RegisterState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    preferences.saveToken(result.data!!.token!!)
                    _state.value = RegisterState(data = result.data)
                }

                is NetworkResponse.Error -> {

                    _state.value = RegisterState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}