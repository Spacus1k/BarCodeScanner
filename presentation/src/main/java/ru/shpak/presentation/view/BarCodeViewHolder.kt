package ru.shpak.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shpak.domain.model.BarCode
import ru.shpak.domain.utils.dateToString
import ru.shpak.presentation.R
import ru.shpak.presentation.databinding.ItemBarCodeListBinding
import ru.shpak.presentation.utils.OnItemClickListener

class BarCodeViewHolder private constructor(
    private val binding: ItemBarCodeListBinding,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun createViewHolder(
            parent: ViewGroup,
            clickListener: OnItemClickListener
        ): BarCodeViewHolder {
            val binding = ItemBarCodeListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return BarCodeViewHolder(binding, clickListener)
        }
    }

    fun bind(barCode: BarCode) {
        binding.barCode.text = barCode.barCode
        binding.date.text = dateToString(barCode.date)

        binding.root.setOnClickListener {
            itemClickListener.onItemClick(barCode)
        }
    }
}
