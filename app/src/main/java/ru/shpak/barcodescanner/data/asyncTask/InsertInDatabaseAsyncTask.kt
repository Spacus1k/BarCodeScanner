package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.data.AppDatabase
import ru.shpak.barcodescanner.model.BarCode

class InsertInDatabaseAsyncTask(database: AppDatabase, inputBarCode: BarCode) :
    AsyncTask<Unit, Unit, Unit>() {
    private val db = database
    private val barCode = inputBarCode

    override fun doInBackground(vararg params: Unit?) {
        db.barCodeDao().insert(barCode)

    }
}