package com.example.forkode

import com.example.forkode.TypeTickets.*

class Ticket : CheckAddTickets {
    private var countAdultTickets = 0
    private var countKidTickets = 0
    private var countBabyTickets = 0
    private val MAX_COUNT_TICKETS = 9

    override fun checkAddTicket(typeTicket: TypeTickets, countTicket: Int): ResultAddTicket {
        when (typeTicket) {
            is AdultTicket -> return checkAddAdultTicket(countTicket)
            is BabyTicket -> return checkAddBabyTicket(countTicket)
            is KidTicket -> return checkAddKidTicket(countTicket)
        }
    }

    private fun checkAddAdultTicket(count: Int): ResultAddTicket {
        if (!checkAddTicket(count)) {
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Пассажиров должно быть не больее $MAX_COUNT_TICKETS человек"
            return result
        }
        countAdultTickets += count
        return ResultAddTicket.SuccessAddTicket()
    }


    private fun checkAddKidTicket(count: Int): ResultAddTicket {
        if (!checkAddTicket(count)) {
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Пассажиров должно быть не больее $MAX_COUNT_TICKETS человек"
            return result
        }
        countKidTickets += count
        return ResultAddTicket.SuccessAddTicket()

    }

    private fun checkAddBabyTicket(count: Int): ResultAddTicket {
        if (!checkAddTicket(count)) {
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Пассажиров должно быть не больее $MAX_COUNT_TICKETS человек"
            return result
        }

        if (countAdultTickets <= countBabyTickets + count) {
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Младенцев не должно быть больше, чем взрослых"
            return result
        }
        countBabyTickets += count
        return ResultAddTicket.SuccessAddTicket()
    }


    private fun checkAddTicket(count: Int): Boolean {
        return countAdultTickets + countBabyTickets + countKidTickets + count < MAX_COUNT_TICKETS
    }
}