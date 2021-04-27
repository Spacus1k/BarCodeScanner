package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.model.BarCode

class InsertInDatabaseAsyncTask(inputBarCode: BarCode) :
    AsyncTask<Any, Any, Any>() {

    private val barCode = inputBarCode

    override fun doInBackground(vararg params: Any?){
        App.instance.database.barCodeDao().insert(barCode)
    }
}