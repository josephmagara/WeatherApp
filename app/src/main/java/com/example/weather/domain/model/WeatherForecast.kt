package com.example.weather.domain.model

/**
 * Created by josephmagara on 2019-09-02.
 */


data class WeatherForecast(
    val windSpeed: Float,
    val weatherType: WeatherType,
    val location: Location
)


enum class WeatherType {
    SUNNY, CLOUDY, RAINY, OVERCAST, WINDY
}