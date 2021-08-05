package ru.shpak.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_history.*
import ru.shpak.presentation.MainViewModel
import ru.shpak.presentation.R
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.utils.startNewActivity
import ru.shpak.presentation.view.BarCodeAdapter
import javax.inject.Inject

class HistoryFragment : DaggerFragment(R.layout.fragment_history), View.OnClickListener {

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
        initButtons()
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

    private fun initButtons() {
        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    override fun onClick(view: View?) {
        view?.let {
            when (view.id) {
                R.id.float_scan_button -> startScanActivity()
            }
        }
    }

    private fun startScanActivity() {
        activity?.let {
            startNewActivity(
                it.applicationContext,
                ScanActivity::class.java,
                arrayOf(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}