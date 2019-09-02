package com.example.weather.domain

import com.example.weather.domain.model.Location
import com.example.weather.domain.model.WeatherForecast

/**
 * Created by josephmagara on 2019-09-02.
 */
interface WeatherService {

    fun requestWeeklyWeatherForecast() : WeatherForecast

    fun setPreferredLocation(location: Location)

    fun saveLocation(location: Location)

    fun retrieveAllSavedLocations() : List<Location>

    fun subscribeToLiveUpdatesStream()
}