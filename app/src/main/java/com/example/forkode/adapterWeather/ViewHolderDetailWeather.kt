package com.example.forkode.adapterWeather

import android.view.View
import com.example.forkode.R
import com.example.forkode.base.BaseViewHolder
import com.example.forkode.network.WeatherDetail
import com.google.android.material.textview.MaterialTextView

class ViewHolderDetailWeather(itemView: View) :BaseViewHolder<WeatherDetail>(itemView) {

    var tv_someText :MaterialTextView = itemView.findViewById(R.id.temperature)

    override fun onBind(item: WeatherDetail) {
        tv_someText.text = item.temperature.toString()
    }


}