package ru.shpak.presentation.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import javax.inject.Inject

class PermissionManagerImpl @Inject constructor() : PermissionManager {

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun isCameraPermissionGranted(activity: Activity): Boolean =
        ContextCompat.checkSelfPermission(
            activity,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    override fun requestCameraPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(android.Manifest.permission.CAMERA),
            REQUEST_CODE
        )
    }
}