package ru.shpak.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import ru.shpak.presentation.MainViewModel
import ru.shpak.presentation.R
import ru.shpak.presentation.di.initPresentationSubcomponent
import ru.shpak.presentation.view.BarCodeAdapter
import javax.inject.Inject

class HistoryFragment : Fragment(R.layout.fragment_history) {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private val adapter = BarCodeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresentationSubcomponent.getComponent()?.let { viewModel = it.getViewModel() }
    }

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