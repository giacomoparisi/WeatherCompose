package com.giacomoparisi.entities.location

data class Location(
    val name: String,
    val country: String,
    val lat: Double,
    val lon: Double
) {

    companion object {

        fun mock(): Location =
            Location(
                name = "Florence",
                country = "Italy",
                lat = 43.77,
                lon = 11.25
            )

    }

}
