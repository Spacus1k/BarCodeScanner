package ru.shpak.presentation.utils

import android.content.Context
import android.content.Intent
import android.support.v4.media.MediaBrowserCompat
import androidx.annotation.IntDef
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