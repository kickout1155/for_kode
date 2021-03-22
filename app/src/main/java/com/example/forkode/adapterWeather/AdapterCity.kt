package com.example.forkode.adapterWeather

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.forkode.OnViewHolderClickListener
import com.example.forkode.R
import com.example.forkode.base.BaseAdapter
import com.example.forkode.model.City

class AdapterCity : BaseAdapter<City, ViewHolderCity>() {

    private lateinit var viewHolder: ViewHolderCity
    private var onViewHolderClickListener: OnViewHolderClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCity {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_city, parent, false)
        viewHolder = ViewHolderCity(view)
        viewHolder.setOnItemClickListener(onViewHolderClickListener)
        return viewHolder
    }

    fun setOnClickListener(onViewHolderClickListener: OnViewHolderClickListener) {
        this.onViewHolderClickListener = onViewHolderClickListener
    }
}