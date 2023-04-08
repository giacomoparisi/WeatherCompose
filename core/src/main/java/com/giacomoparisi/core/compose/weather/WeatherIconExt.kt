package com.giacomoparisi.core.compose.weather

import com.giacomoparisi.core.R
import com.giacomoparisi.entities.weather.WeatherCondition

fun WeatherCondition.icon(isDay: Boolean): Int =
    if (isDay) iconDay()
    else iconNight()

fun WeatherCondition.iconDay(): Int =
    when (this) {
        WeatherCondition.Blizzard -> R.drawable.day_blizzard
        WeatherCondition.BlowingSnow -> R.drawable.day_blowing_snow
        WeatherCondition.Clear -> R.drawable.day_clear
        WeatherCondition.Cloudy -> R.drawable.day_cloudy
        WeatherCondition.Fog -> R.drawable.day_fog
        WeatherCondition.FreezingDrizzle -> R.drawable.day_freezing_drizzle
        WeatherCondition.FreezingFog -> R.drawable.day_freezing_fog
        WeatherCondition.HeavyFreezingDrizzle -> R.drawable.day_heavy_freezing_drizzle
        WeatherCondition.HeavyRain -> R.drawable.night_heavy_rain
        WeatherCondition.HeavyRainAtTimes -> R.drawable.day_heavy_rain_at_times
        WeatherCondition.HeavySnow -> R.drawable.day_heavy_snow
        WeatherCondition.IcePellets -> R.drawable.day_ice_pellets
        WeatherCondition.LightDrizzle -> R.drawable.day_patchy_light_drizzle
        WeatherCondition.LightFreezingRain -> R.drawable.day_light_freezing_rain
        WeatherCondition.LightRain -> R.drawable.day_light_rain
        WeatherCondition.LightRainShower -> R.drawable.day_patchy_rain
        WeatherCondition.LightShowersOfIcePellets -> R.drawable.day_light_showers_of_ice_pellets
        WeatherCondition.LightSleet -> R.drawable.day_light_sleet
        WeatherCondition.LightSleetShowers -> R.drawable.day_patchy_sleet
        WeatherCondition.LightSnow -> R.drawable.day_light_snow
        WeatherCondition.LightSnowShowers -> R.drawable.day_patchy_light_snow
        WeatherCondition.Mist -> R.drawable.day_mist
        WeatherCondition.ModerateOrHeavyFreezingRain -> R.drawable.day_light_freezing_rain
        WeatherCondition.ModerateOrHeavyRainShower -> R.drawable.day_heavy_rain_at_times
        WeatherCondition.ModerateOrHeavyRainWithThunder -> R.drawable.day_moderate_or_heavy_rain_with_thunder
        WeatherCondition.ModerateOrHeavyShowersOfIcePellets -> R.drawable.day_moderate_or_heavy_showers_of_ice_pellets
        WeatherCondition.ModerateOrHeavySleet -> R.drawable.day_light_sleet
        WeatherCondition.ModerateOrHeavySleetShowers -> R.drawable.day_moderate_or_heavy_sleet_showers
        WeatherCondition.ModerateOrHeavySnowShowers -> R.drawable.day_heavy_rain_at_times
        WeatherCondition.ModerateOrHeavySnowWithThunder -> R.drawable.day_moderate_or_heavy_snow_with_thunder
        WeatherCondition.ModerateRain -> R.drawable.day_patchy_rain
        WeatherCondition.ModerateRainAtTimes -> R.drawable.day_light_rain
        WeatherCondition.ModerateSnow -> R.drawable.day_light_snow
        WeatherCondition.Overcast -> R.drawable.day_cloudy
        WeatherCondition.PartlyCloudy -> R.drawable.day_partially_cloud
        WeatherCondition.PatchyFreezingDrizzlePossible -> R.drawable.day_patchy_freezing_drizzle
        WeatherCondition.PatchyHeavySnow -> R.drawable.day_patchy_heavy_snow
        WeatherCondition.PatchyLightDrizzle -> R.drawable.day_patchy_light_drizzle
        WeatherCondition.PatchyLightRain -> R.drawable.day_patchy_rain
        WeatherCondition.PatchyLightRainWithThunder -> R.drawable.day_thunder
        WeatherCondition.PatchyLightSnow -> R.drawable.day_patchy_light_snow
        WeatherCondition.PatchyLightSnowWithThunder -> R.drawable.day_patchy_light_snow_with_thunder
        WeatherCondition.PatchyModerateSnow -> R.drawable.day_patchy_light_snow
        WeatherCondition.PatchyRainPossible -> R.drawable.day_patchy_rain
        WeatherCondition.PatchySleetPossible -> R.drawable.day_patchy_sleet
        WeatherCondition.PatchySnowPossible -> R.drawable.day_patchy_snow
        WeatherCondition.ThunderyOutbreaksPossible -> R.drawable.day_thunder
        WeatherCondition.TorrentialRainShower -> R.drawable.day_torrential_rain_shower
    }

fun WeatherCondition.iconNight(): Int =
    when (this) {
        WeatherCondition.Blizzard -> R.drawable.night_blizzard
        WeatherCondition.BlowingSnow -> R.drawable.night_blowing_snow
        WeatherCondition.Clear -> R.drawable.night_clear
        WeatherCondition.Cloudy -> R.drawable.night_cloudy
        WeatherCondition.Fog -> R.drawable.night_fog
        WeatherCondition.FreezingDrizzle -> R.drawable.night_freezing_drizzle
        WeatherCondition.FreezingFog -> R.drawable.night_freezing_fog
        WeatherCondition.HeavyFreezingDrizzle -> R.drawable.night_heavy_freezing_drizzle
        WeatherCondition.HeavyRain -> R.drawable.night_heavy_rain
        WeatherCondition.HeavyRainAtTimes -> R.drawable.night_heavy_rain_at_times
        WeatherCondition.HeavySnow -> R.drawable.night_heavy_snow
        WeatherCondition.IcePellets -> R.drawable.night_ice_pellets
        WeatherCondition.LightDrizzle -> R.drawable.night_patchy_light_drizzle
        WeatherCondition.LightFreezingRain -> R.drawable.night_light_freezing_rain
        WeatherCondition.LightRain -> R.drawable.night_light_rain
        WeatherCondition.LightRainShower -> R.drawable.night_patchy_rain
        WeatherCondition.LightShowersOfIcePellets -> R.drawable.night_light_showers_of_ice_pellets
        WeatherCondition.LightSleet -> R.drawable.night_light_sleet
        WeatherCondition.LightSleetShowers -> R.drawable.night_patchy_sleet
        WeatherCondition.LightSnow -> R.drawable.night_light_snow
        WeatherCondition.LightSnowShowers -> R.drawable.night_patchy_light_snow
        WeatherCondition.Mist -> R.drawable.night_mist
        WeatherCondition.ModerateOrHeavyFreezingRain -> R.drawable.night_light_freezing_rain
        WeatherCondition.ModerateOrHeavyRainShower -> R.drawable.night_heavy_rain_at_times
        WeatherCondition.ModerateOrHeavyRainWithThunder -> R.drawable.night_moderate_or_heavy_rain_with_thunder
        WeatherCondition.ModerateOrHeavyShowersOfIcePellets -> R.drawable.night_moderate_or_heavy_showers_of_ice_pellets
        WeatherCondition.ModerateOrHeavySleet -> R.drawable.night_light_sleet
        WeatherCondition.ModerateOrHeavySleetShowers -> R.drawable.night_moderate_or_heavy_sleet_showers
        WeatherCondition.ModerateOrHeavySnowShowers -> R.drawable.night_heavy_rain_at_times
        WeatherCondition.ModerateOrHeavySnowWithThunder -> R.drawable.night_moderate_or_heavy_snow_with_thunder
        WeatherCondition.ModerateRain -> R.drawable.night_patchy_rain
        WeatherCondition.ModerateRainAtTimes -> R.drawable.night_light_rain
        WeatherCondition.ModerateSnow -> R.drawable.night_light_snow
        WeatherCondition.Overcast -> R.drawable.night_cloudy
        WeatherCondition.PartlyCloudy -> R.drawable.night_partially_cloud
        WeatherCondition.PatchyFreezingDrizzlePossible -> R.drawable.night_patchy_freezing_drizzle
        WeatherCondition.PatchyHeavySnow -> R.drawable.night_patchy_heavy_snow
        WeatherCondition.PatchyLightDrizzle -> R.drawable.night_patchy_light_drizzle
        WeatherCondition.PatchyLightRain -> R.drawable.night_patchy_rain
        WeatherCondition.PatchyLightRainWithThunder -> R.drawable.night_thunder
        WeatherCondition.PatchyLightSnow -> R.drawable.night_patchy_light_snow
        WeatherCondition.PatchyLightSnowWithThunder -> R.drawable.night_patchy_light_snow_with_thunder
        WeatherCondition.PatchyModerateSnow -> R.drawable.night_patchy_light_snow
        WeatherCondition.PatchyRainPossible -> R.drawable.night_patchy_rain
        WeatherCondition.PatchySleetPossible -> R.drawable.night_patchy_sleet
        WeatherCondition.PatchySnowPossible -> R.drawable.night_patchy_snow
        WeatherCondition.ThunderyOutbreaksPossible -> R.drawable.night_thunder
        WeatherCondition.TorrentialRainShower -> R.drawable.night_torrential_rain_shower
    }