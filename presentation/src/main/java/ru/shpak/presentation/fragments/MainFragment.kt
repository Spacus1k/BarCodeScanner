package ru.shpak.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.R
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.utils.replaceFragment
import ru.shpak.presentation.utils.startNewActivity

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    companion object {
        const val MAIN_FRAGMENT_TAG = "MainFragment"
        fun newInstance() = MainFragment()
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
                R.id.scanButton -> startScanActivity()
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

    private fun openHistoryFragment() {
        activity?.let {
            replaceFragment(
                it.supportFragmentManager,
                R.id.fragment_container,
                HistoryFragment.newInstance(),
                HistoryFragment.HISTORY_FRAGMENT_TAG,
            )
        }
    }
}