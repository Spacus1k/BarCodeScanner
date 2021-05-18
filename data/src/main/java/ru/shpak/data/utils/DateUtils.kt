package ru.shpak.data.utils

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    companion object {
        const val DATE_FORMAT = "dd/MM/yyyy HH:mm:ss"
        val locale: Locale = Locale.US
    }

    @TypeConverter
    fun dateToString(date: Date): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, locale)
        return dateFormat.format(date)
    }

    @TypeConverter
    fun stringToDate(stringDate: String): Date? {
        val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, locale)
        return simpleDateFormat.parse(stringDate)
    }
}