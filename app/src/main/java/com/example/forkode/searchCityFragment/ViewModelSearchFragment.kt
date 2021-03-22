package com.example.forkode.searchCityFragment

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forkode.model.City
import com.example.forkode.network.RetrofitBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelSearchFragment : ViewModel() {

    private val _listCity  = MutableLiveData<MutableList<City>>()
    val listCity : LiveData<MutableList<City>> get() = _listCity

    init {

        _listCity.value = City.getDefaultListCity()

        RetrofitBuilder.cityApi.getCityByString("Мос", "ru", listOf("city"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val k =0
                },
                {
                    val j =0
                }
            )

    }

    fun downloadCity(text: String) {


    }




}