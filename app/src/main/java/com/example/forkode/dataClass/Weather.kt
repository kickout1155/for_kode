package com.example.forkode.network

import com.google.gson.annotations.SerializedName

data class Weather(
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
    val temperature: Double,

    @SerializedName("temp_min")
    val temperatureMin: Double,

    @SerializedName("temp_max")
    val temperatureMax: Double
)