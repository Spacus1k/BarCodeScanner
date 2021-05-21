package ru.shpak.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.utils.replaceFragment

class MainFragment : Fragment(R.layout.fragment_main),  View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun initButtons() {
        scanButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.let {
            when (view.id) {
                R.id.historyButton -> openHistoryFragment()
                R.id.scanButton -> openScanFragment()
            }
        }
    }

    private fun openHistoryFragment() {
        replaceFragment(
            activity?.supportFragmentManager?.beginTransaction(),
            R.id.fragment_container,
            HistoryFragment()
        )
    }

    private fun openScanFragment() {
        replaceFragment(
            activity?.supportFragmentManager?.beginTransaction(),
            R.id.fragment_container,
            ScanFragment()
        )
    }
}