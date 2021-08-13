package ru.shpak.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bar_code_list.view.*
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.dateToString
import ru.shpak.presentation.R
import ru.shpak.presentation.utils.OnItemClickListener

class BarCodeViewHolder private constructor(
    itemView: View, private val itemClickListener: OnItemClickListener
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun createViewHolder(
            parent: ViewGroup,
            clickListener: OnItemClickListener
        ): BarCodeViewHolder {

            return BarCodeViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(
                        R.layout.item_bar_code_list,
                        parent, false
                    ),
                clickListener
            )
        }
    }

    private val barCodeView: TextView = itemView.barCode
    private val dateView: TextView = itemView.date

    fun bind(barCode: BarCode) {
        barCodeView.text = barCode.barCode
        dateView.text = dateToString(barCode.date)

        itemView.setOnClickListener {
            itemClickListener.onItemClick(barCode)
        }
    }
}