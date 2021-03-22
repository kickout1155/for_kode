package com.example.forkode.network

import com.example.forkode.network.RetrofitBuilder.weatherApi
import io.reactivex.rxjava3.core.Observable

class RepositoryWeather(private val weatherApi: WeatherApi) {

    fun getWeather(city: String): Observable<Weather> {
        return weatherApi.getWeather(city)
    }

}