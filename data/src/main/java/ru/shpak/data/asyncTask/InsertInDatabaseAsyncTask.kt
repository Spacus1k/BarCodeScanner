package ru.shpak.data.asyncTask

import android.os.AsyncTask
import ru.shpak.data.App
import ru.shpak.data.model.BarCodeData

class InsertInDatabaseAsyncTask(inputBarCodeData: BarCodeData) :
    AsyncTask<Any, Any, Any>() {

    private val barCode = inputBarCodeData

    override fun doInBackground(vararg params: Any?) {
        App.instance.database.barCodeDao().insert(barCode)
    }
}