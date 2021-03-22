package com.example.forkode

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class DatePickerTicket :
    DatePickerDialog.OnDateSetListener {

    private val calendar: Calendar = Calendar.getInstance()
    private var callbackDatePicker: CallbackDatePicker? = null
    fun showDatePicker(context: Context) {
        setActualDateInCalendar()
        val dialog = DatePickerDialog(
            context,
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        dialog.datePicker.minDate = calendar.timeInMillis
        dialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val dateString = getStringDateForFormat(year, month, dayOfMonth)
        callbackDatePicker?.callbackDateString(dateString)
    }

    fun getActualDayString(): String {
        setActualDateInCalendar()
        return getStringDateForFormat(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    private fun getStringDateForFormat(year: Int, month: Int, dayOfMonth: Int): String {
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("dd MMM EEEE")
        return dateFormat.format(calendar.time)
    }

    private fun setActualDateInCalendar() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        calendar.set(year, month, day)
    }

    fun setCallbackDatePickerDate(callbackDatePicker: CallbackDatePicker) {
        this.callbackDatePicker = callbackDatePicker
    }
}