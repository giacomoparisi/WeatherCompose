package com.giacomoparisi.data.repositories.weather

import com.giacomoparisi.data.datasource.network.getApiService
import com.giacomoparisi.data.repositories.weather.network.WeatherApi
import com.giacomoparisi.domain.usecases.weather.WeatherRepository
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Provides
    @Singleton
    fun provideApi(moshi: Moshi): WeatherApi =
        getApiService(moshi = moshi, baseUrl = "https://api.weatherapi.com")

}

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherBindModule {

    @Binds
    abstract fun bindRepository(repository: WeatherRepositoryImpl): WeatherRepository

}