package com.example.forkode

class Ticket : CheckTickets {

    private val MAX_COUNT_TICKETS = 9

    override fun checkCountTickets(
        countAdultTicket: Int,
        countKidTicket: Int,
        countBabyTicket: Int
    ): ResultAddTicket {

        if (countAdultTicket+countBabyTicket+countKidTicket>MAX_COUNT_TICKETS){
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Пассажиров должно быть не больее $MAX_COUNT_TICKETS человек"
            return result
        }

        if (countAdultTicket < countBabyTicket){
            val result = ResultAddTicket.ErrorAddTicket()
            result.message = "Младенцев не должно быть больше, чем взрослых"
            return result
        }

        return ResultAddTicket.SuccessAddTicket()

    }
}