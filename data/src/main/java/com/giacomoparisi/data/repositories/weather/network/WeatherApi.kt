package com.giacomoparisi.data.repositories.weather.network

import com.giacomoparisi.data.repositories.weather.network.response.WeatherDaysResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getWeatherDays(
        @Query("key") key: String,
        @Query("q") location: String,
        @Query("days") days: Int,
        @Query("aqi") airQuality: String,
        @Query("alerts") alerts: String,
    ): WeatherDaysResponse

}