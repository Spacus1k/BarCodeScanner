package ru.shpak.barcodescanner.data

import ru.shpak.barcodescanner.utils.Util

class Data {
    companion object {
        val firstList = Util.createBareCodeList(15, "item from first list ")
        val secondList = Util.createBareCodeList(15, "item from second list")
    }
}
