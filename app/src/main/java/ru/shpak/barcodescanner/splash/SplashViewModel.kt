package ru.shpak.barcodescanner.splash

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.splash.timer.Timer
import ru.shpak.barcodescanner.splash.timer.TimerImpl
import javax.inject.Inject

class SplashViewModel : ViewModel() {
    private val _iconId = MutableLiveData<@DrawableRes Int>()
    val iconId: LiveData<Int> get() = _iconId

    private val _timerDone = MutableLiveData(false)
    val timerDone: LiveData<Boolean> get() = _timerDone

    @Inject
    lateinit var timer: Timer

    init {
        App.getComponent().inject(this)
        loadImage()
    }

    private fun loadImage() {
        _iconId.value = R.drawable.ic_flag_by
    }

    fun createDelay(delayInMills: Long) {
        timer.delayAction(delayInMills) {
            _timerDone.value = true
        }
    }
}