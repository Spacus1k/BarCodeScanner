package ru.shpak.presentation.utils

import android.content.Context
import android.widget.Toast

fun showDefaultMassage(context: Context,text:String, ){
    val toast= Toast.makeText(context,text, Toast.LENGTH_LONG)
    toast.show()
}