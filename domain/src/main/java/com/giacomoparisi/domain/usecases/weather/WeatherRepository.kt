package com.giacomoparisi.domain.usecases.weather

import com.giacomoparisi.entities.weather.WeatherDays

interface WeatherRepository {

    suspend fun getWeatherDays(): WeatherDays

}