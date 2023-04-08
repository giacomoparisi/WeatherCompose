package com.giacomoparisi.entities.weather

import java.time.Instant

data class WeatherHour(
    val instant: Instant,
    val isDay: Boolean,
    val condition: WeatherCondition,
    val tempC: Float,
    val tempF: Float,
    val windMpH: Float,
    val windKmH: Float,
    val windDegree: Float,
    val windDir: String,
    val pressureMB: Double,
    val pressureIN: Double,
    val precipMM: Float,
    val precipIN: Float,
    val humidity: Float,
    val chanceOfRain: Float,
    val chanceOfSnow: Float,
)
