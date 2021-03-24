package com.example.forkode.searchCityFragment

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forkode.base.BaseViewModel
import com.example.forkode.model.City
import com.example.forkode.network.RepositoryCity
import com.example.forkode.network.RetrofitBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ViewModelSearchFragment : BaseViewModel() {

    private val _listCity = MutableLiveData<MutableList<City>>()
    val listCity: LiveData<MutableList<City>> get() = _listCity
    val repositoryCity: RepositoryCity = RepositoryCity(RetrofitBuilder.cityApi)

    init {

        _listCity.value = City.getDefaultListCity()


    }

    //примерно вот так, только репозиторий надо передавать в конструкторе(ну я бы передавал, т.к. пока с дагером плохо знаком)
    fun downloadCity(text: String) {
        addDisposable(repositoryCity.getCityByString(text)
            .debounce(1,TimeUnit.SECONDS)
            . subscribeOn (Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _listCity.value = it as MutableList<City>
                },
                {
                    it.printStackTrace()
                    _message.value = "не удалось получить список городов"
                }
            )
        )
    }


}