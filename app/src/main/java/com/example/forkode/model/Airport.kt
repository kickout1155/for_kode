package com.example.forkode.model

class Airport {
    var name = ""
    companion object{
        fun getDefaultAirport():Airport{
          val airport = Airport()
          airport.name = "Все аэропорты"
          return airport
        }
    }



}