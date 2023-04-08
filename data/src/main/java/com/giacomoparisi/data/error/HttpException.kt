package com.giacomoparisi.data.error

import com.giacomoparisi.domain.error.WeatherComposeException
import com.giacomoparisi.domain.ext.catchToNullSuspend
import okhttp3.RequestBody
import okio.Buffer
import retrofit2.HttpException


suspend fun HttpException.mapToFourBooksException(): WeatherComposeException {

    val raw = response()?.raw()
    val request = raw?.request
    val response = response()

    val requestJson =
        request?.body.bodyToString()

    val responseJson =
        response?.errorBody()?.string()

    return WeatherComposeException.NetworkErrorHTTP(
        code(),
        request?.url.toString(),
        request?.method,
        request?.headers?.get("Authorization"),
        requestJson,
        responseJson,
        null
    )

}

private suspend fun RequestBody?.bodyToString(): String? =
    catchToNullSuspend {

        this?.let {
            val buffer = Buffer()
            it.writeTo(buffer)
            buffer.readUtf8()
        }

    }
