package ru.shpak.barcodescanner.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bar_code_list.view.*
import ru.shpak.barcodescanner.R
import ru.shpak.barcodescanner.model.BarCode

class BarCodeViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun createViewHolder(parent: ViewGroup) =
            BarCodeViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(
                        R.layout.item_bar_code_list,
                        parent, false
                    )
            )
    }

    private val barCodeView: TextView = itemView.barCode
    private val dateView: TextView = itemView.date

    fun bind(barCode: BarCode) {
        barCodeView.text = barCode.barCode
        dateView.text = barCode.date.toString()
    }
}