package com.giacomoparisi.domain.usecases.weather

import com.giacomoparisi.entities.weather.WeatherDays
import javax.inject.Inject

class GetDayWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(): WeatherDays =
        repository.getWeatherDays()

}