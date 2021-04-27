package ru.shpak.barcodescanner.utils

import ru.shpak.barcodescanner.utils.Constants.DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.US)
    return dateFormat.format(Date())
}