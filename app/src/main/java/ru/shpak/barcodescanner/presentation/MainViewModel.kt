package ru.shpak.barcodescanner.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.data.asyncTask.DeleteFromDatabaseAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.GetListAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.InsertInDatabaseAsyncTask
import ru.shpak.barcodescanner.domain.BarCodeInteractor
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.start

class MainViewModel : ViewModel() {

    val barCodes = MutableLiveData<List<BarCode>>()
     val interactor: BarCodeInteractor = BarCodeInteractor()

    private fun addBarCode(barCode: BarCode) {
        interactor.addBarCode(barCode)
    }

    private fun deleteBarCode(barCode: BarCode) {
       interactor.deleteBarCode(barCode)
    }

    private fun loadBarCodes() {
        barCodes.value = interactor.getBarCodeList()
    }
}