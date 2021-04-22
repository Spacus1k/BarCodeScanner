package ru.shpak.barcodescanner.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BarCode(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "barCode") var barCode: String,
    @ColumnInfo(name = "date") val date: String
)