package com.giacomoparisi.core.compose.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.giacomoparisi.entities.weather.WeatherHour

@Composable
fun WeatherHour.background(): Brush =
    when(isDay) {
        true ->
            Brush.verticalGradient(
                listOf(
                    Color(0xFF5AC3EB),
                    Color(0xFF1E47E8),
                )
            )
        false -> TODO()
    }