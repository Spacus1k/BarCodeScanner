package ru.shpak.domain

import android.app.Application
import android.content.Context
import ru.shpak.domain.utils.ScanMode
import java.lang.NullPointerException
import javax.inject.Inject

class ScanModeInteractorImpl @Inject constructor() : ScanModeInteractor {

    companion object {
        private const val SHARED_PREF_NAME = "ScanModeSharedPrefs"
        private const val NULL_SCAN_MODE_EXCEPTION_MESSAGE = "Scan mode cannot be null"
        private const val KEY = "ScanMode"
    }

    override fun saveScanMode(application: Application, scanMode: ScanMode) {
        val sharedPreferences = application.getSharedPreferences(
            SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
        sharedPreferences?.edit()?.apply {
            putInt(KEY, scanMode.value)
            apply()
        }
    }

    override fun getScanMode(application: Application): ScanMode {
        val value = application.getSharedPreferences(
            SHARED_PREF_NAME,
            Context.MODE_PRIVATE
        )
            .getInt(KEY, ScanMode.STOP.value)

        return when (value) {
            ScanMode.STOP.value -> ScanMode.STOP
            ScanMode.NONSTOP.value -> ScanMode.NONSTOP
            else -> throw IllegalStateException(NULL_SCAN_MODE_EXCEPTION_MESSAGE)
        }
    }
}