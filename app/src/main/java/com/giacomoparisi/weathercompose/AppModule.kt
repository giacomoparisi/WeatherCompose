package com.giacomoparisi.weathercompose

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.sync.Mutex

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun mutex(): Mutex = Mutex()

}