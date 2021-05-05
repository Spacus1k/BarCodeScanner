package ru.shpak.domain.utils

import ru.shpak.data.model.BarCodeData
import ru.shpak.data.utils.DateUtils
import ru.shpak.domain.model.BarCode
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "dd/MM/yyyy HH:mm:ss"

fun dateToString(date: Date): String {
    val dateFormat = SimpleDateFormat(DateUtils.DATE_FORMAT, Locale.US)
    return dateFormat.format(date)
}

fun toListBarCode(listBarCodeData: List<BarCodeData>): List<BarCode> {
    val listBarCodeView = mutableListOf<BarCode>()
    for (item in listBarCodeData) {
        listBarCodeView.add(BarCode(item.barCode, item.date))
    }
    return listBarCodeView
}