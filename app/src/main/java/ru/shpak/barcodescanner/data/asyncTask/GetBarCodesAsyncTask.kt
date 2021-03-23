package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.data.AppDatabase
import ru.shpak.barcodescanner.model.BarCode

class GetBarCodesAsyncTask() : AsyncTask<Unit, Unit, List<BarCode>>() {

    override fun doInBackground(vararg params: Unit?): List<BarCode> {
        return App.instance.database.barCodeDao().getAll()
    }
}