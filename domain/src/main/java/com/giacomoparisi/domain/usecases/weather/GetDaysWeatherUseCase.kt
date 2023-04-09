package com.giacomoparisi.domain.usecases.weather

import com.giacomoparisi.entities.weather.WeatherDays
import javax.inject.Inject

class GetDaysWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(): WeatherDays? =
        repository.getWeatherDays()

}