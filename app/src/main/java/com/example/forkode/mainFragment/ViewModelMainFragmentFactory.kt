package com.example.forkode.mainFragment

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forkode.CheckTickets

class ViewModelMainFragmentFactory(
    private val checkTickets: CheckTickets,
    private val context: Context?
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelMainFragment::class.java)) {
            ViewModelMainFragment(checkTickets,context) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}