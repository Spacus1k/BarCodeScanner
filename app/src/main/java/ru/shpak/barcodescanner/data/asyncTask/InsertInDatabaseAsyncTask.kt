package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.model.BarCode

class InsertInDatabaseAsyncTask(inputBarCode: BarCode) :
    AsyncTask<Unit, Unit, Unit>() {

    private val barCode = inputBarCode

    override fun doInBackground(vararg params: Unit?) {
        App.instance.database.barCodeDao().insert(barCode)
    }
}