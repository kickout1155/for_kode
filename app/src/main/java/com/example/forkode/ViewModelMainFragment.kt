package com.example.forkode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMainFragment() : ViewModel() {

    val DEFAULT_COUNT = 1

    private val _message = SingleLiveEvent<String>()
    val message: LiveData<String> = _message

    private val _fromWhereCity = MutableLiveData<String>()
    val fromWhereCity: LiveData<String> = _fromWhereCity

    private val _fromWhereAirport = MutableLiveData<String>()
    val fromWhereAirport: LiveData<String> = _fromWhereAirport

    private val _whereCity = MutableLiveData<String>()
    val whereCity: LiveData<String> = _whereCity

    private val _whereAirport = MutableLiveData<String>()
    val whereAirport: LiveData<String> = _whereAirport

    private val _countAdultTickets = MutableLiveData<Int>()
    val countAdultTickets: LiveData<Int> = _countAdultTickets

    private val _countKidTickets = MutableLiveData<Int>()
    val countKidTickets: LiveData<Int> = _countKidTickets

    private val _countBabyTickets = MutableLiveData<Int>()
    val countBabyTickets: LiveData<Int> = _countBabyTickets

    lateinit var checkTickets: CheckAddTickets

    constructor(
        checkTickets: CheckAddTickets
    ) : this() {
        this.checkTickets = checkTickets
    }

    init {
        _fromWhereCity.value = "Откуда"
        _fromWhereAirport.value = "Все аэропорты"

        _whereCity.value = "Куда"
        _whereAirport.value = "Все аэропорты"

        _countAdultTickets.value = DEFAULT_COUNT
    }

    fun reversClick() {

        val tempValueCity = fromWhereCity.value ?: ""
        val tempValueAirport = fromWhereAirport.value ?: ""

        _fromWhereCity.value = whereCity.value
        _fromWhereAirport.value = whereAirport.value

        _whereCity.value = tempValueCity
        _whereAirport.value = tempValueAirport

    }

    fun addAdultTicket() {
        val resultCheck = checkTickets.checkAddTicket(TypeTickets.AdultTicket(), DEFAULT_COUNT)
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
        }

    }

    fun deleteAdultTicket() {

    }


}