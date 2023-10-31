package com.example.ecommercejetpack.domain.use_case


import android.util.Log
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.data.remote.dto.RegisterDto
import com.example.ecommercejetpack.domain.model.AuthModel
import com.example.ecommercejetpack.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke(registerDto: RegisterDto): Flow<NetworkResponse<AuthModel>> = flow {
        try {
            emit(NetworkResponse.Loading())
            val response = authRepository.register(registerDto)
            Log.e("error api call errorBody", response.errorBody().toString())
            if (response.isSuccessful && response.body() != null) {
                emit(NetworkResponse.Success(data = response.body()))
            } else {
                try {
                    var jObjError = JSONObject(response.errorBody()!!.charStream().readText());
                    var errorMsg = jObjError.getJSONObject("error");
                    errorMsg.keys().forEach { keyString ->
                        var keyValue = errorMsg.getJSONArray(keyString)
                        emit(NetworkResponse.Error(message = keyValue.get(0).toString()))
                        delay(500)
                    }
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