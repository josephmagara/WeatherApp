package com.example.weather.data

import com.example.weather.domain.WeatherService
import com.example.weather.domain.model.Location
import com.example.weather.domain.model.WeatherForecast
import com.example.weather.domain.model.WeatherType

/**
 * Created by josephmagara on 2019-09-02.
 */
class WeatherRestService : WeatherService {

    override fun retrieveAllSavedLocations(): List<Location> = listOf()

    override fun saveLocation(location: Location) {}

    override fun requestWeeklyWeatherForecast() : WeatherForecast =
        WeatherForecast(10f, WeatherType.SUNNY, Location(983f, 332f))

    override fun setPreferredLocation(location: Location) {}

    override fun subscribeToLiveUpdatesStream() {}
}