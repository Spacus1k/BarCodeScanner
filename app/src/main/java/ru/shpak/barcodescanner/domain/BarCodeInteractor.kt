package ru.shpak.barcodescanner.domain

import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.data.asyncTask.DeleteFromDatabaseAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.GetListAsyncTask
import ru.shpak.barcodescanner.data.asyncTask.InsertInDatabaseAsyncTask
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.start

class BarCodeInteractor: Interactor{

    private val database = App.getApplicationContext().getDatabase()

     override fun addBarCode(barCode: BarCode) {
        InsertInDatabaseAsyncTask(database, barCode).start()
    }

    override fun deleteBarCode(barCode: BarCode) {
        DeleteFromDatabaseAsyncTask(barCode).start()
    }

    override fun getBarCodeList(): List<BarCode>? {
       return GetListAsyncTask(database).start()
    }
}