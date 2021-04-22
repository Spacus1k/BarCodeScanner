package ru.shpak.barcodescanner.utils

import java.text.SimpleDateFormat

import java.util.*

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    return sdf.format(Date())
}

