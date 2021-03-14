package com.example.forkode

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    @GET("/guide/hs/getHeroesHit/V2/getHeroesHitV2")
    fun getAllCity(@Query("id") idHeroes: String?): Observable<List<City>>

}