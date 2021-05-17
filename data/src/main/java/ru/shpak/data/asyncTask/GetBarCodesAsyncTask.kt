package ru.shpak.data.asyncTask

import android.os.AsyncTask
import ru.shpak.data.DatabaseHolder.appDatabase
import ru.shpak.data.model.BarCodeData

class GetBarCodesAsyncTask() : AsyncTask<Any, Any, List<BarCodeData>>() {

    override fun doInBackground(vararg params: Any?): List<BarCodeData> {
        return appDatabase?.barCodeDao()?.getAll() ?: emptyList()
    }
}