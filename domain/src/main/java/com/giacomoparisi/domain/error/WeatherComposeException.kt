package com.giacomoparisi.domain.error

sealed class WeatherComposeException : Throwable() {

    /* --- common --- */

    class Unknown : WeatherComposeException()
    class NetworkErrorTimeOut : WeatherComposeException()
    class NetworkErrorUnknownHost : WeatherComposeException()
    data class NetworkErrorHTTP(
            val code: Int,
            val endpoint: String?,
            val method: String?,
            val token: String?,
            val requestBody: String?,
            val responseBody: String?,
            val errorMessage: String?
    ) : WeatherComposeException()
}