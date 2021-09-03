package ru.shpak.presentation.utils

import android.app.Activity

interface PermissionManager {

    fun isCameraPermissionGranted(activity: Activity): Boolean

    fun requestCameraPermission(activity: Activity)
}