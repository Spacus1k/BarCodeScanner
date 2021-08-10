package ru.shpak.domain

import ru.shpak.domain.model.BarCode

/**
 * The Interactor which used for connection with bard codes data
 * */
interface BarCodeInteractor {

    /**
     * @param scanResult - the bar code which will be added
     * */
    suspend fun addBarCode(scanResult: String)

    /**
     *@param id - the identifier of the barcode which will be deleted
     *  */

    suspend fun removeBarCode(id: Long)

    /**
     * The method  returns bar code list
     *  */

     suspend fun getBarCodeList(): List<BarCode>

    /**
     * The method removes all bar codes
     *  */
    suspend fun removeAllBarCodes()
}