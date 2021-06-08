package ru.shpak.barcodescanner.splash.timer

interface Timer {
    fun delayAction(timeInMills: Long, action : () -> Unit)
}