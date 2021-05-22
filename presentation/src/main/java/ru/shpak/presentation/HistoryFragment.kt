package ru.shpak.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import ru.shpak.presentation.view.BarCodeAdapter

class HistoryFragment : Fragment(R.layout.fragment_history) {

    companion object {
        fun newInstance() =
            HistoryFragment()
    }

    private val adapter = BarCodeAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarCodeRecycleView()
        viewModel.loadBarCodes()
    }

    private fun initObservers() {
        viewModel.barCodes.observe(this) { barCodes ->
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