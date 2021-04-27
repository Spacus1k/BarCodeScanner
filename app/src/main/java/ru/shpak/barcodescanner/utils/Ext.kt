package ru.shpak.barcodescanner.utils

import android.os.AsyncTask

fun <T, T1, T2> AsyncTask<T, T1, T2>.start() =
    this.execute().get()