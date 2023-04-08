package com.giacomoparisi.entities.weather

import com.giacomoparisi.entities.location.Location
import java.time.Instant

data class WeatherDays(
    val instant: Instant,
    val location: Location,
    val current: WeatherHour,
    val days: List<WeatherDay>,
)
