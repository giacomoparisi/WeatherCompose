package com.giacomoparisi.data.repositories.weather.network.response

import com.squareup.moshi.Json


data class ForecastResponse(
    @Json(name = "forecastday") val forecastDay: List<ForecastDayResponse>? = null
)

data class ForecastDayResponse(
    @Json(name = "date") val date: String? = null,
    @Json(name = "date_epoch") val dateEpoch: Int? = null,
    @Json(name = "day") val day: ForecastDayDetailResponse? = null,
    @Json(name = "hour") val hour: ArrayList<ForecastHourResponse>? = null
)

data class ForecastDayDetailResponse(
    @Json(name = "maxtemp_c") val maxtempC: Double? = null,
    @Json(name = "maxtemp_f") val maxtempF: Double? = null,
    @Json(name = "mintemp_c") val mintempC: Double? = null,
    @Json(name = "mintemp_f") val mintempF: Double? = null,
    @Json(name = "avgtemp_c") val avgtempC: Double? = null,
    @Json(name = "avgtemp_f") val avgtempF: Double? = null,
    @Json(name = "maxwind_mph") val maxwindMph: Double? = null,
    @Json(name = "maxwind_kph") val maxwindKph: Double? = null,
    @Json(name = "totalprecip_mm") val totalprecipMm: Int? = null,
    @Json(name = "totalprecip_in") val totalprecipIn: Int? = null,
    @Json(name = "totalsnow_cm") val totalsnowCm: Int? = null,
    @Json(name = "avgvis_km") val avgvisKm: Int? = null,
    @Json(name = "avgvis_miles") val avgvisMiles: Int? = null,
    @Json(name = "avghumidity") val avghumidity: Int? = null,
    @Json(name = "daily_will_it_rain") val dailyWillItRain: Int? = null,
    @Json(name = "daily_chance_of_rain") val dailyChanceOfRain: Int? = null,
    @Json(name = "daily_will_it_snow") val dailyWillItSnow: Int? = null,
    @Json(name = "daily_chance_of_snow") val dailyChanceOfSnow: Int? = null,
    @Json(name = "condition") val condition: ConditionResponse? = ConditionResponse(),
    @Json(name = "uv") val uv: Int? = null
)

data class ForecastHourResponse(
    @Json(name = "time_epoch") val timeEpoch: Int? = null,
    @Json(name = "time") val time: String? = null,
    @Json(name = "temp_c") val tempC: Int? = null,
    @Json(name = "temp_f") val tempF: Double? = null,
    @Json(name = "is_day") val isDay: Int? = null,
    @Json(name = "condition") val condition: ConditionResponse? = ConditionResponse(),
    @Json(name = "wind_mph") val windMph: Double? = null,
    @Json(name = "wind_kph") val windKph: Double? = null,
    @Json(name = "wind_degree") val windDegree: Int? = null,
    @Json(name = "wind_dir") val windDir: String? = null,
    @Json(name = "pressure_mb") val pressureMb: Int? = null,
    @Json(name = "pressure_in") val pressureIn: Double? = null,
    @Json(name = "precip_mm") val precipMm: Int? = null,
    @Json(name = "precip_in") val precipIn: Int? = null,
    @Json(name = "humidity") val humidity: Int? = null,
    @Json(name = "cloud") val cloud: Int? = null,
    @Json(name = "feelslike_c") val feelslikeC: Double? = null,
    @Json(name = "feelslike_f") val feelslikeF: Double? = null,
    @Json(name = "windchill_c") val windchillC: Double? = null,
    @Json(name = "windchill_f") val windchillF: Double? = null,
    @Json(name = "heatindex_c") val heatindexC: Int? = null,
    @Json(name = "heatindex_f") val heatindexF: Double? = null,
    @Json(name = "dewpoint_c") val dewpointC: Double? = null,
    @Json(name = "dewpoint_f") val dewpointF: Int? = null,
    @Json(name = "will_it_rain") val willItRain: Int? = null,
    @Json(name = "chance_of_rain") val chanceOfRain: Int? = null,
    @Json(name = "will_it_snow") val willItSnow: Int? = null,
    @Json(name = "chance_of_snow") val chanceOfSnow: Int? = null,
    @Json(name = "vis_km") val visKm: Int? = null,
    @Json(name = "vis_miles") val visMiles: Int? = null,
    @Json(name = "gust_mph") val gustMph: Double? = null,
    @Json(name = "gust_kph") val gustKph: Double? = null,
    @Json(name = "uv") val uv: Int? = null
)