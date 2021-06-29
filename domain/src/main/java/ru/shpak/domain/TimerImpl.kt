package ru.shpak.domain

import android.os.Looper
import android.os.Handler
import javax.inject.Inject

class TimerImpl @Inject constructor() : Timer {
    override fun delayAction(timeInMills: Long, action: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({ action.invoke() }, timeInMills)
    }
}