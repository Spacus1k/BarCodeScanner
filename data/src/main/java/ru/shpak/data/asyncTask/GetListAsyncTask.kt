package ru.shpak.data.asyncTask

import android.os.AsyncTask
import ru.shpak.data.App
import ru.shpak.data.model.BarCodeData

class GetListAsyncTask() : AsyncTask<Unit, Unit, List<BarCodeData>>() {

    override fun doInBackground(vararg params: Unit?): List<BarCodeData> {
        return App.instance.database.barCodeDao().getAll()
    }
}