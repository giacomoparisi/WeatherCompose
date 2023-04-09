package com.giacomoparisi.data.repositories.weather.network.response

import com.giacomoparisi.entities.location.Location
import com.giacomoparisi.entities.weather.WeatherDays
import com.squareup.moshi.Json
import java.time.Instant

data class WeatherDaysResponse(
    @Json(name = "location") val location: LocationResponse? = null,
    @Json(name = "current") val current: CurrentWeatherResponse? = null,
    @Json(name = "forecast") val forecast: ForecastResponse? = null
) {

    fun toWeatherDays(): WeatherDays? {

        val locationValue = location?.toLocation()
        val instant = current?.lastUpdatedEpoch?.let { Instant.ofEpochMilli(it) }
        val condition = current?.condition?.toWeatherCondition()
        val currentWeather = current?.toWeatherHour()

        return when (null) {
            locationValue, instant, condition, currentWeather -> null
            else ->
                WeatherDays(
                    location = locationValue,
                    instant = instant,
                    current = currentWeather,
                    days = emptyList()
                )
        }

    }
}

data class LocationResponse(
    @Json(name = "name") val name: String? = null,
    @Json(name = "region") val region: String? = null,
    @Json(name = "country") val country: String? = null,
    @Json(name = "lat") val lat: Double? = null,
    @Json(name = "lon") val lon: Double? = null,
) {

    fun toLocation(): Location? =
        when (null) {
            name, region, lat, lon, country -> null
            else ->
                Location(
                    name = name,
                    region = region,
                    lat = lat,
                    lon = lon,
                    country = country
                )
        }
}