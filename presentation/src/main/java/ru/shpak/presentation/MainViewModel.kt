package ru.shpak.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.domain.BarCodeInteractor
import ru.shpak.domain.model.BarCode
import javax.inject.Inject

class MainViewModel @Inject constructor(private val interactor: BarCodeInteractor) : ViewModel() {

    val barCodes = MutableLiveData<List<BarCode>>()

    init {
        loadBarCodes()
    }

    fun addBarCode(scanResult: String) {
        interactor.addBarCode(scanResult)
    }

    private fun removeBarCode(id: Long) {
        interactor.removeBarCode(id)
    }

     fun loadBarCodes() {
        barCodes.value = interactor.getBarCodeList()
    }
}