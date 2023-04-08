package com.giacomoparisi.home.data

import com.giacomoparisi.domain.datatype.LazyData
import com.giacomoparisi.entities.weather.WeatherDays

data class HomeState(
    val weatherDays: LazyData<WeatherDays> = LazyData.Empty
)