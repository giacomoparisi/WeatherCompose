package com.giacomoparisi.data.repositories.weather.network.response

import com.giacomoparisi.entities.weather.WeatherHour
import com.squareup.moshi.Json
import java.time.Instant

data class CurrentWeatherResponse(
    @Json(name = "last_updated_epoch") val lastUpdatedEpoch: Long? = null,
    @Json(name = "last_updated") val lastUpdated: String? = null,
    @Json(name = "temp_c") val tempC: Double? = null,
    @Json(name = "temp_f") val tempF: Double? = null,
    @Json(name = "is_day") val isDay: Int? = null,
    @Json(name = "condition") val condition: ConditionResponse? = null,
    @Json(name = "wind_mph") val windMpH: Double? = null,
    @Json(name = "wind_kph") val windKmH: Double? = null,
    @Json(name = "wind_degree") val windDegree: Double? = null,
    @Json(name = "wind_dir") val windDir: String? = null,
    @Json(name = "pressure_mb") val pressureMB: Double? = null,
    @Json(name = "pressure_in") val pressureIN: Double? = null,
    @Json(name = "precip_mm") val precipMM: Double? = null,
    @Json(name = "precip_in") val precipIN: Double? = null,
    @Json(name = "humidity") val humidity: Double? = null,
) {

    fun toWeatherHour(): WeatherHour? {

        val instant = lastUpdatedEpoch?.let { Instant.ofEpochSecond(it) }
        val weatherCondition = condition?.toWeatherCondition()

        return when (null) {
            instant, isDay, weatherCondition, tempC, tempF, windMpH, windKmH, windDegree,
            windDir, pressureMB, pressureIN, precipIN, precipMM, humidity -> null
            else ->
                WeatherHour(
                    instant = instant,
                    isDay = isDay == 1,
                    condition = weatherCondition,
                    tempC = tempC,
                    tempF = tempF,
                    windMpH = windMpH,
                    windKmH = windKmH,
                    windDegree = windDegree,
                    windDir = windDir,
                    pressureMB = pressureMB,
                    pressureIN = pressureIN,
                    precipIN = precipIN,
                    precipMM = precipMM,
                    humidity = humidity,
                    chanceOfRain = 0.0,
                    chanceOfSnow = 0.0
                )
        }
    }
}