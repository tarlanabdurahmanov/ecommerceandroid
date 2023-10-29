package com.example.ecommercejetpack.domain.use_case


import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.data.remote.dto.LoginDto
import com.example.ecommercejetpack.domain.model.AuthModel
import com.example.ecommercejetpack.domain.model.ErrorModel
import com.example.ecommercejetpack.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(loginDto: LoginDto): Flow<NetworkResponse<AuthModel>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val response = authRepository.login(loginDto)

            if (response.isSuccessful && response.body() != null) {
                emit(NetworkResponse.Success(data = response.body()))
            } else {
                try {
                    val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                    Log.e("error api call error", jsonObj.get("message").toString())
                    emit(
                        NetworkResponse.Error(message = jsonObj.get("message").toString())
                    )
                } catch (e: Exception) {
                    emit(NetworkResponse.Error("Something went wrong."))
                }

            }
        } catch (e: HttpException) {
            emit(NetworkResponse.Error(e.localizedMessage ?: "An unexpected error occurred."))

        } catch (e: IOException) {
            emit(NetworkResponse.Error("Check your internet connection"))
        }
    }
}