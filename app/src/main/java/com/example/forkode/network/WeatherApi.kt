package com.example.forkode.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

//    private val BASE_URL = "api.openweathermap.org"
//    private val API_KEY = "48ad64290be9d19a266b0f8154a22a26"


    @GET("/data/2.5/forecast")
    fun getWeather(@Query("q") city: String, @Query("appid") apiKey: String): Observable<WeatherObject>


    //api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
}