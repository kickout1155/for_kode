package com.example.forkode.network

import com.example.forkode.model.City
import io.reactivex.rxjava3.core.Observable

class RepositoryCity (private val cityApi: CityApi) {

    fun getCityByString(city: String): Observable<List<City>> {
        return cityApi.getCityByString(city)
    }

}