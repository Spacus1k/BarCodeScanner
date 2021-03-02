package ru.shpak.barcodescanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(numberOfItems: Int) : RecyclerView.Adapter<NumberAdapter.NumberVieWHolder>() {
    companion object {
        private const val DEFAULT_NUMBERS_ITEMS = 0
        private const val DEFAULT_VIEW_HOLDER_COUNT = 0
    }

    private var numberItems = DEFAULT_NUMBERS_ITEMS
    private var viewHolderCount = DEFAULT_VIEW_HOLDER_COUNT

    init {
        numberItems = numberOfItems
    }

    inner class NumberVieWHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val listItemNumberView: TextView =
            itemView.findViewById(R.id.numberItem) as TextView
        val viewHolderIndex: TextView =
            itemView.findViewById(R.id.viewHolderNumber) as TextView


        fun bind(listIndex: Int) {
            listItemNumberView.text = listIndex.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberVieWHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.number_list_item
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutIdForListItem, parent, false)

        val viewHolder = NumberVieWHolder(view)
        viewHolder.viewHolderIndex.text = "ViewHolderIndex: " + viewHolderCount
        viewHolderCount++
        return viewHolder
    }

    override fun onBindViewHolder(holder: NumberVieWHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return numberItems
    }
}