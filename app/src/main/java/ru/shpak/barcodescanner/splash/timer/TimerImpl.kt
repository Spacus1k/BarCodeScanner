package ru.shpak.barcodescanner.splash.timer

import android.os.Handler
import android.os.Looper

class TimerImpl : Timer {
    override fun delayAction(timeInMills: Long, action: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({ action.invoke() }, timeInMills)
    }
}