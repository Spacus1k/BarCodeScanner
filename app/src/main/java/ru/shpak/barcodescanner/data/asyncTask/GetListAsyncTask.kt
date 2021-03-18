package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.data.AppDatabase
import ru.shpak.barcodescanner.model.BarCode

class GetListAsyncTask(database: AppDatabase) : AsyncTask<Unit, Unit, List<BarCode>>() {

    private val db = database
    override fun doInBackground(vararg params: Unit?): List<BarCode> {
        return db.barCodeDao().getAll()
    }
}