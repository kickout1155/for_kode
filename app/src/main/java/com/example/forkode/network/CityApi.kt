package com.example.forkode.network

import com.example.forkode.model.City
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    @GET("/places2")
    fun getCityByString(
        @Query("term") city: String,
        @Query("locale") local: String,
        @Query("types") array: List<String>
    ): Observable<List<City>>

}