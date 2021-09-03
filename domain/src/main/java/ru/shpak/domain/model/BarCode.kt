package ru.shpak.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class BarCode(val id: Long, val barCode: String, val date: Date): Parcelable