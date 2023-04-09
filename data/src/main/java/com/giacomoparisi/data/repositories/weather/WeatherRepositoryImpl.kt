package com.giacomoparisi.data.repositories.weather

import android.content.Context
import com.giacomoparisi.data.R
import com.giacomoparisi.data.repositories.weather.network.WeatherApi
import com.giacomoparisi.domain.ext.nullToError
import com.giacomoparisi.domain.usecases.weather.WeatherRepository
import com.giacomoparisi.entities.weather.WeatherDays
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    @ApplicationContext private val application: Context
) : WeatherRepository {

    override suspend fun getWeatherDays(): WeatherDays? {

        val apiKey = application.getString(R.string.weather_api_key)
        //val ip = api.getIp(key = apiKey).toIp().nullToError()
        return api.getWeatherDays(
            key = apiKey,
            location = "auto:ip",
            days = 3,
            airQuality = "no",
            alerts = "no"
        ).toWeatherDays()

    }
}