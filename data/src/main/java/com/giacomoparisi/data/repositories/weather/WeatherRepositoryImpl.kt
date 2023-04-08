package com.giacomoparisi.data.repositories.weather

import com.giacomoparisi.domain.usecases.weather.WeatherRepository
import com.giacomoparisi.entities.weather.WeatherDays
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor() : WeatherRepository {

    override suspend fun getWeatherDays(): WeatherDays {
        TODO("Not yet implemented")
    }

}