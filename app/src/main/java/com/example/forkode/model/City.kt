package com.example.forkode.model

import java.io.Serializable

data class City(
    val name: String
    ) : Serializable {


    companion object {
        fun getDefaultListCity() :MutableList<City>{
            val listCity = mutableListOf<City>()
            listCity.add(City("Москва"))
            listCity.add(City("Санкт-Петербург"))
            listCity.add(City("Сочи"))
            listCity.add(City("Калининград"))
            return listCity
        }
    }
}