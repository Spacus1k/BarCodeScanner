package ru.shpak.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.shpak.data.appDatabase
import ru.shpak.data.model.BarCodeData
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.toListBarCode
import javax.inject.Inject

class BarCodeInteractorImpl @Inject constructor() : BarCodeInteractor {

    override suspend fun addBarCode(scanResult: String) {
        val barCode = BarCodeData(barCode = scanResult)
        withContext(Dispatchers.Default) {
            appDatabase?.barCodeDao()?.insert(barCode)

        }
    }

    override suspend fun removeBarCode(id: Long) {
        // TODO: will be implemented later
    }

    override suspend fun getBarCodeList(): List<BarCode> {
        val listBarCodes = withContext(Dispatchers.Default) {
            appDatabase?.barCodeDao()?.getAll() ?: emptyList()
        }
        return listBarCodes.toListBarCode().sortedByDescending { it.date }
    }

    override suspend fun removeAllBarCodes() {
        withContext(Dispatchers.Default) {
            appDatabase?.barCodeDao()?.deleteAll()
        }
    }
}


