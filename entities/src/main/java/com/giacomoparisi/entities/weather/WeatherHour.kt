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
) {


    companion object {

        fun mock(): WeatherHour =
            WeatherHour(
                instant = Instant.ofEpochMilli(1681045040599L),
                isDay = true,
                condition = WeatherCondition.Clear,
                tempC = 18.0,
                tempF = 64.4,
                windMpH = 9.4,
                windKmH = 15.1,
                windDegree = 10.0,
                windDir = "N",
                pressureMB = 1019.0,
                pressureIN = 30.09,
                precipMM = 0.0,
                precipIN = 0.0,
                humidity = 42.0,
                chanceOfRain = 0.0,
                chanceOfSnow = 0.0,
            )

    }

}
