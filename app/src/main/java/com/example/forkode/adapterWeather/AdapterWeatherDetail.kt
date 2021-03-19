package com.example.forkode.adapterWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.forkode.R
import com.example.forkode.base.BaseAdapter
import com.example.forkode.network.WeatherDetail

class AdapterWeatherDetail:BaseAdapter<WeatherDetail,ViewHolderDetailWeather>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDetailWeather {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_weather,parent,false)
        return ViewHolderDetailWeather(view)
    }
}