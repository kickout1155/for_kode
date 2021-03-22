package com.example.forkode.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/data/2.5/forecast")
    fun getWeather(@Query("q") city: String): Observable<Weather>

}