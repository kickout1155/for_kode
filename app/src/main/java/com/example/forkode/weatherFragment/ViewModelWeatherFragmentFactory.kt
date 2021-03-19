package com.example.forkode.weatherFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forkode.mainFragment.ViewModelMainFragment
import com.example.forkode.model.City
import com.example.forkode.network.Repository

class ViewModelWeatherFragmentFactory(
    private val cityFromWhere: City,
    private val cityWhere: City,
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelWeatherFragment::class.java)) {
            ViewModelWeatherFragment(cityFromWhere, cityWhere, repository) as T
        } else {
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}