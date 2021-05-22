package ru.shpak.presentation.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

fun <T : AppCompatActivity> startNewActivity(
    context: Context,
    activity: Class<T>,
    isCallFromOutsideActivityContext: Boolean
) {
    val intent = Intent(context, activity)
    if (isCallFromOutsideActivityContext) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    startActivity(context, intent, null)
}