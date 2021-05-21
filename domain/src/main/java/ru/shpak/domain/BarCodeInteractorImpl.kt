package ru.shpak.domain

import ru.shpak.domain.utils.start
import ru.shpak.data.asyncTask.RemoveBarCodeAsyncTask
import ru.shpak.data.asyncTask.GetBarCodesAsyncTask
import ru.shpak.data.asyncTask.InsertInDatabaseAsyncTask
import ru.shpak.data.model.BarCodeData
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.toListBarCode

class BarCodeInteractorImpl : BarCodeInteractor {

    override fun addBarCode(scanResult: String) {
        InsertInDatabaseAsyncTask(
            BarCodeData(barCode = scanResult)
        )
            .start()
    }

    override fun removeBarCode(id: Long) {
        RemoveBarCodeAsyncTask(id).start()
    }

    override fun getBarCodeList(): List<BarCode> {
        val listBarCodes = GetBarCodesAsyncTask().start()
        return listBarCodes.toListBarCode().sortedByDescending { it.date }
    }
}