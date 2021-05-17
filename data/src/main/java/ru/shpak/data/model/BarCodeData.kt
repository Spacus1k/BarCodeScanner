package ru.shpak.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.shpak.data.utils.DateUtils
import java.util.*

@Entity
data class BarCodeData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "bar_code")
    var barCode: String,

    @TypeConverters(DateUtils::class)
    @ColumnInfo(name = "date")
    val date: Date = Date()
)