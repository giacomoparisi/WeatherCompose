package com.giacomoparisi.core.compose.loading

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.giacomoparisi.core.R
import com.giacomoparisi.domain.error.WeatherComposeException

fun getErrorMessage(context: Context, exception: WeatherComposeException): String =
    context.getString(getErrorRes(exception))

@Composable
fun getErrorMessage(exception: WeatherComposeException): String =
    stringResource(id = getErrorRes(exception))

private fun getErrorRes(exception: WeatherComposeException): Int =
    when (exception) {
        is WeatherComposeException.Unknown ->
            R.string.COMMON_error
        is WeatherComposeException.NetworkErrorTimeOut ->
            R.string.COMMON_error_network
        is WeatherComposeException.NetworkErrorUnknownHost ->
            R.string.COMMON_error_network
        is WeatherComposeException.NetworkErrorHTTP ->
            R.string.COMMON_error
    }