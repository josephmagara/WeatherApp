package com.example.weather.domain

import com.example.weather.domain.model.WeatherForecast

/**
 * Created by josephmagara on 2019-09-02.
 */
data class WeatherUseCase(val weatherService: WeatherService, val supportsLiveUpdates: Boolean) {

    fun getWeeklyWeatherForecast() : WeatherForecast = weatherService.requestWeeklyWeatherForecast()

    fun requestLiveUpdates(): Boolean =
        if (supportsLiveUpdates)
            weatherService.subscribeToLiveUpdatesStream()
        else false
}