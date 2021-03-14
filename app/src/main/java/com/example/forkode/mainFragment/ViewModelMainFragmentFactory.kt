package com.example.forkode.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forkode.CheckTickets

class ViewModelMainFragmentFactory(
    private val checkTickets: CheckTickets
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelMainFragment::class.java)) {
            ViewModelMainFragment(checkTickets) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}