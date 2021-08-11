package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.R
import ru.shpak.presentation.utils.addFragment
import ru.shpak.presentation.view.BarCodeAdapter
import ru.shpak.presentation.viewModels.MainViewModel
import javax.inject.Inject

class HistoryFragment : DaggerFragment(R.layout.fragment_history),
    BarCodeAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = HistoryFragment()
        const val KEY = "clicked_item"
    }

    @Inject
    lateinit var viewModel: MainViewModel
    private val adapter = BarCodeAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBarCodeRecycleView()
        initObservers()
    }

    override fun onItemClick(position: Int) {
        val clickedItem = adapter.getItem(position)
        val bundle = Bundle().apply {
            putParcelable(KEY, clickedItem)
        }
        val fragment = ClickedItemFragment.newInstance()
        fragment.arguments = bundle
        openClickedItemFragment(fragment)
    }

    private fun initObservers() {
        viewModel.barCodes.observe(viewLifecycleOwner) { barCodes ->
            adapter.updateData(barCodes)
        }
    }

    private fun initBarCodeRecycleView() {
        with(barCodes) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryFragment.adapter
        }
    }

    private fun openClickedItemFragment(fragment: ClickedItemFragment) {
        activity?.let {
            addFragment(
                it.supportFragmentManager, R.id.activity_fragment_container,
                fragment,
                true
            )
        }
    }
}