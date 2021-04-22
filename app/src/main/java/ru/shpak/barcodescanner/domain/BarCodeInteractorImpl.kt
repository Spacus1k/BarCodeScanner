package ru.shpak.barcodescanner.domain

import ru.shpak.barcodescanner.data.asyncTask.RemoveBarCodeAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.GetBarCodesAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.InsertInDatabaseAsyncTask
import ru.shpak.barcodescanner.model.BarCode

class BarCodeInteractorImpl : BarCodeInteractor {

    override fun addBarCode(barCode: BarCode) {
        InsertInDatabaseAsyncTask(barCode).execute().get()
    }

    override fun removeBarCode(barCode: BarCode) {
        RemoveBarCodeAsyncTask(barCode).execute().get()
    }

    override fun getBarCodeList(): List<BarCode> {
        return GetBarCodesAsyncTask().execute().get()
    }
}