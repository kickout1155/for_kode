package com.example.forkode.network

import io.reactivex.rxjava3.core.Observable

class Repository(private val weatherApiHelper: WeatherApiHelper) {

    fun getWeather(city: String): Observable<WeatherObject> {
        return weatherApiHelper.getWeather(city)
    }

}