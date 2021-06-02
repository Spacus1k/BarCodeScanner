package ru.shpak.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.domain.BarCodeInteractorImpl
import ru.shpak.domain.model.BarCode

class MainViewModel : ViewModel() {

    val barCodes = MutableLiveData<List<BarCode>>()
    private val interactor: BarCodeInteractorImpl = BarCodeInteractorImpl()

    init {
        loadBarCodes()
    }

    fun addBarCode(scanResult: String) {
        interactor.addBarCode(scanResult)
    }

    private fun removeBarCode(id: Long) {
        interactor.removeBarCode(id)
    }

    private fun loadBarCodes() {
        barCodes.value = interactor.getBarCodeList()
    }
}