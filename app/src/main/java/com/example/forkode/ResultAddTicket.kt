package com.example.forkode

sealed class ResultAddTicket {

    var message = ""

    class ErrorAddTicket : ResultAddTicket()
    class SuccessAddTicket : ResultAddTicket()
}