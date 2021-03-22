package com.example.forkode.adapterWeather

import android.view.View
import com.example.forkode.R
import com.example.forkode.base.BaseViewHolder
import com.example.forkode.network.WeatherDetail
import com.google.android.material.textview.MaterialTextView

class ViewHolderDetailWeather(itemView: View) : BaseViewHolder<WeatherDetail>(itemView) {

    var tv_date: MaterialTextView = itemView.findViewById(R.id.date_weather)
    var tv_titleTemperatureMin: MaterialTextView = itemView.findViewById(R.id.title_temperature_min)
    var tv_temperatureMin: MaterialTextView = itemView.findViewById(R.id.temperature_min)
    var tv_titleTemperature: MaterialTextView = itemView.findViewById(R.id.title_temperature)
    var tv_temperature: MaterialTextView = itemView.findViewById(R.id.temperature)
    var tv_titleTemperatureMax: MaterialTextView = itemView.findViewById(R.id.title_temperature_max)
    var tv_temperatureMax: MaterialTextView = itemView.findViewById(R.id.temperature_max)

    override fun onBind(item: WeatherDetail) {
        tv_date.text = item.date
        tv_titleTemperatureMin.text = itemView.context.getString(R.string.min_temperature)
        tv_temperatureMin.text = item.temperature.temperatureMin.toString()
        tv_titleTemperature.text = itemView.context.getString(R.string.temperature)
        tv_temperature.text = item.temperature.temperature.toString()
        tv_titleTemperatureMax.text = itemView.context.getString(R.string.max_temperature)
        tv_temperatureMax.text = item.temperature.temperatureMax.toString()
    }
}