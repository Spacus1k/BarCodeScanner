package ru.shpak.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.shpak.data.appDatabase
import ru.shpak.data.model.BarCodeData
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.toListBarCode
import javax.inject.Inject

class BarCodeInteractorImpl @Inject constructor() : BarCodeInteractor, CoroutineDispatcherProvider {

    override suspend fun addBarCode(barCodeValue: String) {
        val barCode = BarCodeData(barCode = barCodeValue)
        withContext(getCoroutineDispatcher()) {
            appDatabase?.barCodeDao()?.insert(barCode)
        }
    }

    override suspend fun removeBarCodeById(id: Long) {
        withContext(getCoroutineDispatcher()) {
            appDatabase?.barCodeDao()?.delete(id)
        }
    }

    override suspend fun getBarCodeList(): List<BarCode> {
        val listBarCodes = withContext(getCoroutineDispatcher()) {
            appDatabase?.barCodeDao()?.getAll() ?: emptyList()
        }
        return listBarCodes.toListBarCode().sortedByDescending { it.date }
    }

    override suspend fun removeAllBarCodes() {
        withContext(getCoroutineDispatcher()) {
            appDatabase?.barCodeDao()?.deleteAll()
        }
    }

    override fun getCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}


