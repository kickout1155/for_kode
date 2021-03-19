package com.example.forkode.network

import com.google.gson.annotations.SerializedName

data class WeatherObject(
    @SerializedName("list")
    val listDetail: MutableList<WeatherDetail>
)

data class WeatherDetail(
    @SerializedName("dt_txt")
    val date: String,
    @SerializedName("main")
    val temperature: Temperature
)

data class Temperature(
    @SerializedName("temp")
    val temperatureKelvin: Double
)