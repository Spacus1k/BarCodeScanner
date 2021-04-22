package ru.shpak.barcodescanner.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.barcodescanner.domain.BarCodeInteractorImpl
import ru.shpak.barcodescanner.model.BarCode

class MainViewModel : ViewModel() {

    val barCodes = MutableLiveData<List<BarCode>>()
    private val interactor: BarCodeInteractorImpl = BarCodeInteractorImpl()

    fun addBarCode(barCode: BarCode) {
        interactor.addBarCode(barCode)
    }

    private fun deleteBarCode(barCode: BarCode) {
        interactor.removeBarCode(barCode)
    }

    fun loadBarCodes() {
        barCodes.value = interactor.getBarCodeList()
    }
}