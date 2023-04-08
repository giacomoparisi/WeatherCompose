package com.giacomoparisi.entities.weather

import java.time.Instant

data class WeatherHour(
    val instant: Instant,
    val isDay: Boolean,
    val condition: WeatherCondition,
    val tempC: Double,
    val tempF: Double,
    val windMpH: Double,
    val windKmH: Double,
    val windDegree: Double,
    val windDir: String,
    val pressureMB: Double,
    val pressureIN: Double,
    val precipMM: Double,
    val precipIN: Double,
    val humidity: Double,
    val chanceOfRain: Double,
    val chanceOfSnow: Double,
)
