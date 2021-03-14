package com.example.forkode

interface CheckTickets {

    fun checkCountTickets(
        countAdultTicket: Int,
        countKidTicket: Int,
        countBabyTicket: Int
    ): ResultAddTicket

}