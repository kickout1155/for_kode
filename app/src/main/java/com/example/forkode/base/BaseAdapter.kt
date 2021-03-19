package com.example.forkode.base

import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private val listItems :MutableList<T> = ArrayList<T>()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    fun getItem(position: Int): T {
        return listItems[position]
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    fun addAndNotify(list:MutableList<T>){
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    fun clear(){
        listItems.clear()
    }

}