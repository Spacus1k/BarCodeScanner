package ru.shpak.data.asyncTask

import android.os.AsyncTask
import ru.shpak.data.appDatabase

class RemoveAllBarCodesAsyncTask() : AsyncTask<Any, Any, Any>() {

    override fun doInBackground(vararg params: Any?) {
        appDatabase?.barCodeDao()?.deleteAll()
    }
}