package ru.shpak.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.shpak.data.model.BarCodeData
import ru.shpak.data.utils.DateUtils

const val DATABASE_VERSION = 1

@Database(
    entities = [BarCodeData::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(DateUtils::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val NAME_DATABASE = "barcodeDB"
    }

    abstract fun barCodeDao(): BarCodeDao
}