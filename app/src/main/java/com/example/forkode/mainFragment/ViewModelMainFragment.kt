package com.example.forkode.mainFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forkode.CheckTickets
import com.example.forkode.ResultAddTicket
import com.example.forkode.SingleLiveEvent

class ViewModelMainFragment() : ViewModel() {

    val MIN_COUNT_ADULT = 1
    val MIN_COUNT_KID = 0
    val MIN_COUNT_BABY = 0
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

    lateinit var checkTickets: CheckTickets

    constructor(
        checkTickets: CheckTickets
    ) : this() {
        this.checkTickets = checkTickets
    }

    init {
        _fromWhereCity.value = "Откуда"
        _fromWhereAirport.value = "Все аэропорты"

        _whereCity.value = "Куда"
        _whereAirport.value = "Все аэропорты"

        _countAdultTickets.value = MIN_COUNT_ADULT
        _countKidTickets.value = MIN_COUNT_KID
        _countBabyTickets.value = MIN_COUNT_BABY
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
        logg()
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
        logg()
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
        logg()
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
        logg()
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
        logg()
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
        logg()
    }

    fun logg(){
        Log.d("ticket", "${countAdultTickets.value} ${countKidTickets.value} ${countBabyTickets.value}")
    }

}