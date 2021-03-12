package com.example.forkode

sealed class TypeTickets {

    class AdultTicket : TypeTickets()
    class KidTicket : TypeTickets()
    class BabyTicket : TypeTickets()

}