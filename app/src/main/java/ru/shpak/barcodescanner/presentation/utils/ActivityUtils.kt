package ru.shpak.barcodescanner.presentation.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

fun <T>startNewActivity(context: Context, activity: Class<T>){
    val intent = Intent(context, activity)
    startActivity(context, intent, null )
}