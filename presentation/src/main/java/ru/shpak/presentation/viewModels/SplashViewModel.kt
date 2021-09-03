package ru.shpak.presentation.viewModels

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.domain.Timer
import ru.shpak.presentation.R
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val timer: Timer): ViewModel() {

    private val _iconId = MutableLiveData<@DrawableRes Int>()
    val iconId: LiveData<Int> get() = _iconId

    private val _timerDone = MutableLiveData(false)
    val timerDone: LiveData<Boolean> get() = _timerDone

    init {
        loadImage()
    }

    private fun loadImage() {
        _iconId.value = R.drawable.ic_qr_code
    }

    fun createDelay(delayInMills: Long) {
        timer.delayAction(delayInMills) {
            _timerDone.value = true
        }
    }
}