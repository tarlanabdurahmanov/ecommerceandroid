package com.example.ecommercejetpack.presentation.auth.login


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.common.Preferences
import com.example.ecommercejetpack.data.remote.dto.LoginDto
import com.example.ecommercejetpack.domain.use_case.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val preferences: Preferences,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> get() = _state

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun login(email: String, password: String, isChecked: Boolean) {
        val body = LoginDto(email, password);
        loginUseCase(body).onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    result.data!!.token?.let { preferences.saveToken(it) }
                    result.data.user?.let { preferences.saveUser(it) }
                    _state.value = LoginState(data = result.data)
                }

                is NetworkResponse.Error -> {
                    _state.value = LoginState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)
    }


}