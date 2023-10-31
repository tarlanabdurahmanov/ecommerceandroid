package com.example.ecommercejetpack.presentation.splash

import android.os.Looper
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ecommercejetpack.common.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import android.os.Handler
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val preferences: Preferences) : ViewModel() {
    private val _state = mutableStateOf<SplashState>(SplashState())
    val state: State<SplashState> = _state

    init {
        val userFound = preferences.getToken()
        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            _state.value = SplashState(tokenExist = !userFound.isNullOrEmpty(), navTrigger = true)
        }, 1000)
    }


}