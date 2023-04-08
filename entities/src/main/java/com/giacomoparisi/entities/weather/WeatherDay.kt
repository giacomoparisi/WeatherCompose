package com.giacomoparisi.entities.weather

import com.giacomoparisi.entities.location.Location
import java.time.Instant

data class WeatherDay(
    val location: Location,
    val instant: Instant,
    val condition: WeatherCondition,
    val hours: List<WeatherHour>,
    val maxTempC: Float,
    val maxTempF: Float,
    val minTempC: Float,
    val minTempF: Float,
    val avgTempC: Float,
    val avgTempF: Float,
    val maxWindMph: Float,
    val maxWindKmH: Float,
    val totalPrecipMM: Float,
    val totalPrecipIN: Float,
    val totalSnowCM: Float,
    val avgVisKM: Float,
    val avgVisMiles: Float,
    val avgHumidity: Float,
    val dailyChanceOfRain: Float,
    val dailyChanceOfSnow: Float,
)
