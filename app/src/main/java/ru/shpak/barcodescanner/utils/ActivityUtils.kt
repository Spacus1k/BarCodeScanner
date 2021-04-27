package ru.shpak.barcodescanner.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

fun <T>startNewActivity(context: Context, activity: Class<T>){
    val intent = Intent(context, activity)
    startActivity(context, intent, null )
}

fun AppCompatActivity.hideActionBar(){
    supportActionBar?.hide()
}
