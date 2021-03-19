package com.example.forkode.model

import android.os.Parcelable

sealed class TypeTicket {

    abstract fun getDefaultName(): String

    class FromWhereTicket : TypeTicket() {
        override fun getDefaultName(): String {
            return "Откуда"
        }
    }

    class WhereTicket : TypeTicket() {
        override fun getDefaultName(): String {
            return "Куда"
        }
    }

}

