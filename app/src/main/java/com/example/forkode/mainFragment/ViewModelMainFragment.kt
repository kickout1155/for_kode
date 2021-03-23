package com.example.forkode.mainFragment

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forkode.CheckTickets
import com.example.forkode.R
import com.example.forkode.model.City
import com.example.forkode.ResultAddTicket
import com.example.forkode.SingleLiveEvent
import com.example.forkode.base.BaseViewModel
import com.example.forkode.model.Airport

class ViewModelMainFragment() : BaseViewModel() {

    val MIN_COUNT_ADULT = 1
    val MIN_COUNT_KID = 0
    val MIN_COUNT_BABY = 0
    val DEFAULT_COUNT = 1
    var context: Context? = null

    private val _fromWhereCity = MutableLiveData<City?>()
    val fromWhereCity: LiveData<City?> get() = _fromWhereCity

    private val _fromWhereAirport = MutableLiveData<Airport?>()
    val fromWhereAirport: LiveData<Airport?> get() = _fromWhereAirport

    private val _whereCity = MutableLiveData<City?>()
    val whereCity: LiveData<City?> get() = _whereCity

    private val _whereAirport = MutableLiveData<Airport?>()
    val whereAirport: LiveData<Airport?> get() = _whereAirport

    private val _countAdultTickets = MutableLiveData<Int>()
    val countAdultTickets: LiveData<Int> get() = _countAdultTickets

    private val _countKidTickets = MutableLiveData<Int>()
    val countKidTickets: LiveData<Int> get() = _countKidTickets

    private val _countBabyTickets = MutableLiveData<Int>()
    val countBabyTickets: LiveData<Int> get() = _countBabyTickets

    private val _findTickets = SingleLiveEvent<Boolean>()
    val findTickets: LiveData<Boolean> get() = _findTickets

    lateinit var checkTickets: CheckTickets

    constructor(
        checkTickets: CheckTickets,
        context: Context?
    ) : this() {
        this.checkTickets = checkTickets
        this.context = context
    }

    init {
        _fromWhereAirport.value = Airport.getDefaultAirport()
        _whereAirport.value = Airport.getDefaultAirport()

        _countAdultTickets.value = MIN_COUNT_ADULT
        _countKidTickets.value = MIN_COUNT_KID
        _countBabyTickets.value = MIN_COUNT_BABY
    }

    fun reversClick() {

        val tempValueCity = _fromWhereCity.value
        val tempValueAirport = _fromWhereAirport.value

        _fromWhereCity.value = whereCity.value
        _fromWhereAirport.value = whereAirport.value

        _whereAirport.value = tempValueAirport
        _whereCity.value = tempValueCity

    }

    fun addAdultTicket() {

        val tempCountTicket = countAdultTickets.value ?: 0

        val resultCheck = checkTickets.checkCountTickets(
            tempCountTicket + DEFAULT_COUNT,
            countKidTickets.value ?: 0,
            countBabyTickets.value ?: 0
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }
        _countAdultTickets.value = tempCountTicket + DEFAULT_COUNT
    }

    fun addKidTicket() {
        val tempCountTicket = countKidTickets.value ?: 0

        val resultCheck = checkTickets.checkCountTickets(
            countAdultTickets.value ?: 0,
            tempCountTicket + DEFAULT_COUNT,
            countBabyTickets.value ?: 0
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }
        _countKidTickets.value = tempCountTicket + DEFAULT_COUNT
    }

    fun addBabyTicket() {
        val tempCountTicket = countBabyTickets.value ?: 0

        val resultCheck = checkTickets.checkCountTickets(
            countAdultTickets.value ?: 0,
            countKidTickets.value ?: 0,
            tempCountTicket + DEFAULT_COUNT,
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }
        _countBabyTickets.value = tempCountTicket + DEFAULT_COUNT
    }


    fun deleteAdultTicket() {

        val tempCountAdultTicket = countAdultTickets.value ?: 0
        var tempCountBabyTicket = countBabyTickets.value ?: 0

        if (tempCountAdultTicket - DEFAULT_COUNT < MIN_COUNT_ADULT) {
            return
        }

        if (tempCountAdultTicket - DEFAULT_COUNT < tempCountBabyTicket) {
            tempCountBabyTicket = tempCountAdultTicket - DEFAULT_COUNT
        }

        val resultCheck = checkTickets.checkCountTickets(
            tempCountAdultTicket - DEFAULT_COUNT,
            countKidTickets.value ?: 0,
            tempCountBabyTicket,
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }

        _countAdultTickets.value = tempCountAdultTicket - 1
        _countBabyTickets.value = tempCountBabyTicket
    }

    fun deleteKidTicket() {
        val tempCountTicket = countKidTickets.value ?: 0

        if (tempCountTicket - DEFAULT_COUNT < MIN_COUNT_KID) {
            return
        }

        val resultCheck = checkTickets.checkCountTickets(
            countAdultTickets.value ?: 0,
            tempCountTicket - DEFAULT_COUNT,
            countBabyTickets.value ?: 0
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }
        _countKidTickets.value = tempCountTicket - DEFAULT_COUNT
    }

    fun deleteBabyTicket() {
        val tempCountTicket = countBabyTickets.value ?: 0

        if (tempCountTicket - DEFAULT_COUNT < MIN_COUNT_BABY) {
            return
        }

        val resultCheck = checkTickets.checkCountTickets(
            countAdultTickets.value ?: 0,
            countKidTickets.value ?: 0,
            tempCountTicket - DEFAULT_COUNT
        )
        if (resultCheck is ResultAddTicket.ErrorAddTicket) {
            _message.value = resultCheck.message
            return
        }
        _countBabyTickets.value = tempCountTicket - DEFAULT_COUNT
    }

    fun setFromWhereCity(city: City) {
        _fromWhereCity.value = city
    }

    fun setWhereCity(city: City) {
        _whereCity.value = city
    }

    fun findTicketClick() {

        if (_fromWhereCity.value == null) {
            _message.value =
                context?.getString(R.string.error_choice_from_where_city)
            return
        }

        if (_whereCity.value == null) {
            _message.value =
                context?.getString(R.string.error_choice_where_city)
            return
        }
        _findTickets.value = true
    }

}