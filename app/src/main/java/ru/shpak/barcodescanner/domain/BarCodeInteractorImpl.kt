package ru.shpak.barcodescanner.domain

import ru.shpak.barcodescanner.data.asyncTask.RemoveBarCodeAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.GetBarCodesAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.InsertInDatabaseAsyncTask
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.start

class BarCodeInteractorImpl : BarCodeInteractor {

    override fun addBarCode(barCode: BarCode) {
        //TODO(use with start )
        InsertInDatabaseAsyncTask(barCode).start()
    }

    override fun removeBarCode(barCode: BarCode) {
        RemoveBarCodeAsyncTask(barCode).start()
    }

    override fun getBarCodeList(): List<BarCode> {
        return GetBarCodesAsyncTask().start()
    }
}