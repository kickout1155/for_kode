package com.example.forkode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelMainFragmentFactory(
    private val checkAddTickets: CheckAddTickets
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelMainFragment::class.java)) {
            ViewModelMainFragment(checkAddTickets) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}