package com.giacomoparisi.core.compose.loading

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.giacomoparisi.domain.datatype.LazyData
import com.giacomoparisi.domain.error.WeatherComposeException

@Composable
fun <T> LoadingError(
    data: LazyData<T>,
    modifier: Modifier = Modifier,
    loading: Boolean = true,
    animated: Boolean = false,
    onRetryClicked: () -> Unit,
    composable: @Composable (T) -> Unit,
) {

    var error by remember { mutableStateOf<WeatherComposeException?>(null) }
    LaunchedEffect(key1 = data) {
        when (data) {
            is LazyData.Error -> error = data.error
            else -> {}
        }
    }

    Box(modifier = modifier) {
        if (animated) {
            AnimatedVisibility(
                visible = data.currentOrPrevious() != null,
                enter = fadeIn(tween(durationMillis = 1000)),
                exit = fadeOut(tween(durationMillis = 1000))
            ) {
                val value = data.currentOrPrevious()
                if (value != null) composable(value)
            }
            AnimatedVisibility(
                visible = data.isLoading() && loading,
                enter = fadeIn(tween(durationMillis = 400)),
                exit = fadeOut(tween(durationMillis = 400))
            ) {
                Loading(modifier = Modifier.fillMaxSize())
            }
            AnimatedVisibility(
                visible = data.isError(),
                enter = fadeIn(tween(durationMillis = 400)),
                exit = fadeOut(tween(durationMillis = 400))
            ) {
                val lastError = error
                if (lastError != null)
                    Error(
                        error = lastError,
                        onRetryClicked = onRetryClicked,
                        modifier = Modifier.fillMaxSize()
                    )
            }
        } else {
            when (data) {
                is LazyData.Data ->
                    composable(data.value)
                is LazyData.Error ->
                    Error(
                        error = data.error,
                        onRetryClicked = onRetryClicked,
                        modifier = Modifier.fillMaxSize()
                    )
                is LazyData.Loading -> {
                    if (data.value != null) composable(data.value!!)
                    if (loading) Loading(modifier = Modifier.fillMaxSize(), size = 200.dp)
                }
                else -> {

                }
            }
        }
    }
}