package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import ru.shpak.domain.model.BarCode
import ru.shpak.presentation.R
import ru.shpak.presentation.databinding.FragmentHistoryBinding
import ru.shpak.presentation.utils.OnItemClickListener
import ru.shpak.presentation.utils.Router
import ru.shpak.presentation.view.BarCodeAdapter
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class HistoryFragment : DaggerFragment(R.layout.fragment_history) {

    companion object {
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private val itemClickListener = object : OnItemClickListener {
        override fun onItemClick(clickedItem: BarCode) {
            openClickedItemFragment(ClickedBarCodeFragment.newInstance(clickedItem))
        }
    }
    private val adapter = BarCodeAdapter(itemClickListener)
    private var router: Router? = null
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)
        initBarCodeRecycleView()
        initObservers()
        router = activity?.let { Router(it, R.id.activity_fragment_container) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadBarCodes()
    }

    private fun initObservers() {
        viewModel.barCodes.observe(viewLifecycleOwner) { barCodes ->
            adapter.updateData(barCodes)
        }
    }

    private fun initBarCodeRecycleView() {
        with(binding.barCodes) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryFragment.adapter
        }
    }

    private fun openClickedItemFragment(fragment: ClickedBarCodeFragment) {
        router?.let {
            it.removeFragment(this)
            it.openFragment(fragment)
        }
    }
}
