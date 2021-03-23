package ru.shpak.barcodescanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.shpak.barcodescanner.model.BarCode

@Dao
interface BarCodeDao {
    @Query("SELECT * FROM barcode")
    fun getAll(): List<BarCode>

    @Query("SELECT * FROM barcode WHERE  id = :id")
    fun getById(id: Long): BarCode

    @Insert
    fun insert(barCode: BarCode)

    @Delete
    fun delete(barCode: BarCode)
}