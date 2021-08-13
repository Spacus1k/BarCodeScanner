package ru.shpak.presentation.utils

import ru.shpak.domain.model.BarCode

interface OnItemClickListener {
    fun onItemClick(clickedItem: BarCode)
}