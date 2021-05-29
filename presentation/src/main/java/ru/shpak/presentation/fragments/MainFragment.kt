package ru.shpak.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.R
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.utils.replaceFragment
import ru.shpak.presentation.utils.startNewActivity

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    companion object {
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

                R.id.scanButton -> activity?.let {
                    startNewActivity(
                        it.applicationContext,
                        ScanActivity::class.java,
                        arrayOf(Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                }
                else -> {
                }
            }
        }
    }

    private fun openHistoryFragment() {
        activity?.let {
            replaceFragment(
                it.supportFragmentManager,
                R.id.fragment_container,
                HistoryFragment.newInstance()
            )
        }
    }
}