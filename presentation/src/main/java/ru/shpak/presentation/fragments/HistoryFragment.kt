package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import ru.shpak.presentation.MainViewModel
import ru.shpak.presentation.R
import ru.shpak.presentation.view.BarCodeAdapter

class HistoryFragment : Fragment(R.layout.fragment_history) {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    private val viewModel: MainViewModel = MainViewModel()
    private val adapter = BarCodeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarCodeRecycleView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.barCodes.observe(viewLifecycleOwner) { barCodes ->
            adapter.updateData(barCodes)
        }
    }

    private fun initBarCodeRecycleView() {
        with(barCodes) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryFragment.adapter
        }
    }
}