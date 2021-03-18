package ru.shpak.barcodescanner.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.shpak.barcodescanner.model.BarCode
import ru.shpak.barcodescanner.utils.Constants

@Database(entities = [BarCode::class], version = Constants.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val NAME_DATABASE = "barcodeDB"
    }

    abstract fun barCodeDao(): BarCodeDao
}
