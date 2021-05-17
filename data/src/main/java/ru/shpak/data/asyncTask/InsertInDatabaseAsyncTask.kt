package ru.shpak.data.asyncTask

import android.os.AsyncTask
import ru.shpak.data.DatabaseHolder.appDatabase
import ru.shpak.data.model.BarCodeData

class InsertInDatabaseAsyncTask(inputBarCodeData: BarCodeData) :
    AsyncTask<Any, Any, Any>() {

    private val barCode = inputBarCodeData

    override fun doInBackground(vararg params: Any?) {
        appDatabase?.barCodeDao()?.insert(barCode)
    }
}