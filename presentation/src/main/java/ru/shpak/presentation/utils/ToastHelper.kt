package ru.shpak.presentation.utils

import android.content.Context
import android.widget.Toast
import com.google.android.material.snackbar.BaseTransientBottomBar

fun showToast(
    context: Context,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, duration).show()
}