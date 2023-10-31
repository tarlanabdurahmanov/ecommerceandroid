package com.example.ecommercejetpack.domain.use_case

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.ecommercejetpack.common.NetworkResponse
import com.example.ecommercejetpack.data.remote.dto.ProductDetailDto
import com.example.ecommercejetpack.domain.model.ProductDetailModel
import com.example.ecommercejetpack.domain.model.ProductModel
import com.example.ecommercejetpack.domain.repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(private val productRepository: ProductRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(productDetailDto: ProductDetailDto): Flow<NetworkResponse<ProductDetailModel>> =
        flow {
            try {
                emit(NetworkResponse.Loading())
                val response = productRepository.productDetail(productDetailDto = productDetailDto)

                if (response.isSuccessful && response.body() != null) {
                    emit(NetworkResponse.Success(data = response.body()))
                } else {
                    try {
                        val jObjError = JSONObject(response.errorBody()!!.charStream().readText());
                        val errorMsg = jObjError.getJSONObject("error");
                        errorMsg.keys().forEach { keyString ->
                            val keyValue = errorMsg.getJSONArray(keyString)
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