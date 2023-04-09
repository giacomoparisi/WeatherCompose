package com.giacomoparisi.data.repositories.weather.network.response

import com.giacomoparisi.entities.location.Ip
import com.squareup.moshi.Json

data class IpResponse(
    @Json(name = "ip") val ip: String? = null,
    @Json(name = "type") val type: String? = null,
    @Json(name = "continent_code") val continentCode: String? = null,
    @Json(name = "continent_name") val continentName: String? = null,
    @Json(name = "country_code") val countryCode: String? = null,
    @Json(name = "country_name") val countryName: String? = null,
    @Json(name = "city") val city: String? = null,
    @Json(name = "region") val region: String? = null,
    @Json(name = "lat") val lat: Double? = null,
    @Json(name = "lon") val lon: Double? = null
) {

    fun toIp(): Ip? =
        when (null) {
            ip, type -> null
            else ->
                Ip(ip = ip, type = type)
        }

}
