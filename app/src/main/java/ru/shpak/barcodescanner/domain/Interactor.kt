package ru.shpak.barcodescanner.domain

import ru.shpak.barcodescanner.model.BarCode

interface Interactor {

    fun addBarCode(barCode: BarCode)

    fun deleteBarCode(barCode: BarCode)

    fun getBarCodeList(): List<BarCode>?

}