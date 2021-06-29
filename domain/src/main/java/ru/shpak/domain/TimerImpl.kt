package ru.shpak.domain

import android.os.Looper
import android.os.Handler

class TimerImpl: Timer {
    override fun delayAction(timeInMills: Long, action: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({action.invoke()},timeInMills)
    }
}