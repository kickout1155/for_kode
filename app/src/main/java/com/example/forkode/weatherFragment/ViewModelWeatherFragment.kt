package com.example.forkode.weatherFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forkode.base.BaseViewModel
import com.example.forkode.model.City
import com.example.forkode.network.RepositoryWeather
import com.example.forkode.network.WeatherDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModelWeatherFragment(
    cityFromWhere: City,
    cityWhere: City,
    repositoryWeather: RepositoryWeather
) : BaseViewModel() {

    private val _cityFromWhere = MutableLiveData<City>()
    val cityFromWhere = _cityFromWhere

    private val _cityWhere = MutableLiveData<City>()
    val cityWhere = _cityWhere

    private val repository = repositoryWeather

    private val _listFromWhereWeather = MutableLiveData<MutableList<WeatherDetail>>()
    val listFromWhereWeather: LiveData<MutableList<WeatherDetail>> = _listFromWhereWeather

    private val _listWhereWeather = MutableLiveData<MutableList<WeatherDetail>>()
    val listWhereWeather: LiveData<MutableList<WeatherDetail>> = _listWhereWeather


    init {
        _cityFromWhere.value = cityFromWhere
        _cityWhere.value = cityWhere
    }

    fun downloadWeather() {

        if (cityWhere.value == null) {
            return
        }

        if (cityFromWhere.value == null) {
            return
        }

        downloadWeatherFromWhereCity(cityFromWhere.value!!.name)
        downloadWeatherWhereCity(cityWhere.value!!.name)
    }

    private fun downloadWeatherFromWhereCity(nameCity: String) {
        addDisposable(
            repository.getWeather(nameCity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _listFromWhereWeather.value = it.listDetail
                    },
                    {
                        it.printStackTrace()
                        _message.value =
                            "Не удалось получить погоду по городу $nameCity.Проверьте подключение к интернету"
                    }
                )
        )
    }

    private fun downloadWeatherWhereCity(nameCity: String) {
        addDisposable(
            repository.getWeather(nameCity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _listWhereWeather.value = it.listDetail
                    },
                    {
                        it.printStackTrace()
                        _message.value =
                            "Не удалось получить погоду по городу $nameCity.Проверьте подключение к интернету"
                    }
                )
        )
    }
}