package com.giacomoparisi.entities.weather

import java.time.Instant

data class WeatherDay(
    val instant: Instant,
    val hours: List<WeatherHour>,
    val condition: WeatherCondition,
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double,
    val avgTempC: Double,
    val avgTempF: Double,
    val maxWindMph: Double,
    val maxWindKmH: Double,
    val totalPrecipMM: Double,
    val totalPrecipIN: Double,
    val totalSnowCM: Double,
    val avgVisKM: Double,
    val avgVisMiles: Double,
    val avgHumidity: Double,
    val dailyChanceOfRain: Double,
    val dailyChanceOfSnow: Double,
)