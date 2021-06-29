package ru.shpak.domain

interface Timer {
    fun delayAction(timeInMills: Long, action: () -> Unit)
}