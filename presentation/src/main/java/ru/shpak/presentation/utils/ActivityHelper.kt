package ru.shpak.presentation.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

fun <T : AppCompatActivity> startNewActivity(
    context: Context,
    activity: Class<T>,
    intentFlags: Array<Int>? = null
) {
    val intent = Intent(context, activity)
    intentFlags?.forEach { intent.addFlags(it) }
    startActivity(context, intent, null)
}