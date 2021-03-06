package ru.shpak.barcodescanner.utils

import ru.shpak.barcodescanner.data.Data
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.view.BarCodeAdapter

class Util {

    companion object {
        var listIndicator = false
        fun swapLists(barCodeAdapter: BarCodeAdapter){

            listIndicator = if(listIndicator){
                setNewList(barCodeAdapter, Data.firstList)
                false
            } else{
                setNewList(barCodeAdapter, Data.secondList)
                true
            }
        }

        fun createBareCodeList(NumberOfItem: Int, text: String): MutableList<BarCode> {
            val list = mutableListOf<BarCode>()
            for (i in (1..NumberOfItem).withIndex()) {
                list.add(BarCode("date ${i.index}", "$text ${i.index}"))
            }
            return list
        }

        private fun setNewList(barCodeAdapter: BarCodeAdapter, list: List<BarCode>) {
            barCodeAdapter.clear()
            barCodeAdapter.updateData(list)
        }
    }
}