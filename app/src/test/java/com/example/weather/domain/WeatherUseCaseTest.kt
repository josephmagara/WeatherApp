package com.example.weather.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

/**
 * Created by josephmagara on 2019-09-02.
 */

@RunWith(JUnitPlatform::class)
class WeatherUseCaseTest: SubjectSpek<WeatherUseCase>({

    lateinit var weatherService : WeatherService

    var supportsLiveUpdates = false


    subject {
        weatherService = mock()
        WeatherUseCase(weatherService, supportsLiveUpdates)
    }


    given("The app is running on an older device that does not support live updates"){
        beforeGroup {
            weatherService = mock()
            supportsLiveUpdates = false

            println("I) Setting up tests for older devices")
        }

        on("attempting to turn on live updates"){

            println("I. a) Actioning live update test for old devices")

            subject.requestLiveUpdates()

            it("should not turn on live updates"){
                println("I. b) Testing the results of the live update test for old devices")

                verifyZeroInteractions(weatherService)
            }
        }

        on("requesting for the weekly weather forecast"){
            println("I. c) Actioning weekly weather forecast test for old devices")

            subject.getWeeklyWeatherForecast()

            it("should make a request to get the current weekly forecast"){
                println("I. d) Testing the results of the weekly weather forecast test for old devices")
                verify(weatherService).requestWeeklyWeatherForecast()
            }
        }
    }

    given("The app is running on a new device that supports live updates"){
        beforeGroup {
            weatherService = mock()
            supportsLiveUpdates = true
            println("II) Setting up tests for new devices")
        }

        on("attempting to turn on live updates"){
            println("II. a) Actioning live update test for new devices")

            subject.requestLiveUpdates()

            it("should turn on live updates"){
                println("II. b) Testing the results of the live update test for new devices")

                verify(weatherService).subscribeToLiveUpdatesStream()
            }
        }

        on("requesting for the weekly weather forecast"){
            println("II. c) Actioning weekly weather forecast test for new devices")
            subject.getWeeklyWeatherForecast()

            it("should make a request to get the current weekly forecast"){
                println("II. d) Testing the results of the weekly weather forecast test for new devices")

                verify(weatherService).requestWeeklyWeatherForecast()
            }
        }
    }

})