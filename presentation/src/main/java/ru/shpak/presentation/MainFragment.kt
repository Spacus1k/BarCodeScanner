package ru.shpak.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.utils.replaceFragment
import ru.shpak.presentation.utils.startNewActivity

class MainFragment : Fragment(R.layout.fragment_main), View.OnClickListener {

    companion object {
        fun newInstance() =
            MainFragment()
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
                R.id.scanButton -> activity?.let { currentActivity ->
                    startNewActivity(
                        currentActivity.applicationContext,
                        ScanActivity::class.java,
                        true
                    )
                }
                else -> null
            }
        }
    }

    private fun openHistoryFragment() {
        activity?.let {
            replaceFragment(
                it.supportFragmentManager,
                R.id.fragment_container,
                HistoryFragment.newInstance(),
                true
            )
        }
    }
}