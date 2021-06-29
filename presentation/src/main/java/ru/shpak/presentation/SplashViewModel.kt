package ru.shpak.presentation

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Delay
import ru.shpak.domain.Timer
import ru.shpak.domain.TimerImpl

class SplashViewModel : ViewModel() {

    private val timer: Timer = TimerImpl()

    private val _iconId = MutableLiveData<@DrawableRes Int>()
    val iconId: LiveData<Int> get() = _iconId

    private val _timerDone = MutableLiveData(false)
    val timerDone: LiveData<Boolean> get() = _timerDone

    init {
        loadImage()
    }

    private fun loadImage() {
        _iconId.value = R.drawable.ic_qr_scan_512
    }

    fun createDelay(delayInMills: Long) {
        timer.delayAction(delayInMills) {
            _timerDone.value = true
        }
    }
}