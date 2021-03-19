package com.example.forkode.network

import io.reactivex.rxjava3.core.Observable

class WeatherApiHelper(private val weatherApi: WeatherApi) {

    private val API_KEY = "48ad64290be9d19a266b0f8154a22a26"


    fun getWeather(city: String): Observable<WeatherObject> {
        return weatherApi.getWeather(city,API_KEY)
    }

}