package ru.shpak.barcodescanner.domain

import ru.shpak.barcodescanner.model.BarCode

/**
 * The Interactor which used for connection with bard codes data
 * */
interface BarCodeInteractor {

    /**
     * @param barCode - the bar code which will be added
     * */
    fun addBarCode(barCode: BarCode)

    /**
     *@param barCode - the bar code which will be deleted
     *  */

    fun removeBarCode(barCode: BarCode)

    /**
     * The method  returns bar code list
     *  */

    fun getBarCodeList(): List<BarCode>
}