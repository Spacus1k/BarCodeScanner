package ru.shpak.domain

import ru.shpak.domain.model.BarCode

/**
 * The Interactor which used for connection with bard codes data
 * */
interface BarCodeInteractor {

    /**
     * @param barCodeValue - the bar code which will be added
     * */
    suspend fun addBarCode(barCodeValue: String)

    /**
     *@param id - the identifier of the barcode which will be deleted
     *  */
    suspend fun removeBarCodeById(id: Long)

    /**
     * The method  returns bar code list
     *  */
    suspend fun getBarCodeList(): List<BarCode>

    suspend fun removeAllBarCodes()
}