package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_history.*
import ru.shpak.presentation.R
import ru.shpak.presentation.view.BarCodeAdapter
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class HistoryFragment : DaggerFragment(R.layout.fragment_history){

    companion object {
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private val adapter = BarCodeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarCodeRecycleView()
        initObservers()
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadBarCodes()
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