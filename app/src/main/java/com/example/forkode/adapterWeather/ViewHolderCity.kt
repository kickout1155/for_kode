package com.example.forkode.adapterWeather

import android.view.View
import com.example.forkode.R
import com.example.forkode.base.BaseViewHolder
import com.example.forkode.model.City
import com.google.android.material.textview.MaterialTextView

class ViewHolderCity(itemView: View) : BaseViewHolder<City>(itemView) {

    val tv_name: MaterialTextView = itemView.findViewById(R.id.name)
    val tv_airport: MaterialTextView = itemView.findViewById(R.id.airport)

    init {
        tv_name.setOnClickListener {
            clickListener?.onClick(adapterPosition)
        }
    }

    override fun onBind(item: City) {
        tv_name.text = item.name
        tv_airport.text = itemView.context.getString(R.string.all_airport)
    }
}