package ru.shpak.barcodescanner.data.asyncTask

import android.os.AsyncTask
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.model.BarCode

class GetBarCodesAsyncTask() : AsyncTask<Any, Any, List<BarCode>>() {

    override fun doInBackground(vararg params: Any?): List<BarCode> {
        return App.instance.database.barCodeDao().getAll()
    }
}