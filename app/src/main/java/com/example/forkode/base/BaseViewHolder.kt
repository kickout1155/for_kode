package com.example.forkode.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.forkode.OnViewHolderClickListener


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var clickListener:OnViewHolderClickListener? = null

    abstract fun onBind(item: T)

    fun setOnItemClickListener(clickListener: OnViewHolderClickListener?){
        this.clickListener = clickListener
    }
}