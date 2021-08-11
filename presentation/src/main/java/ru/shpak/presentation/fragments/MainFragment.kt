package ru.shpak.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.navigation.NavigationBarView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.R
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.utils.addFragment
import ru.shpak.presentation.utils.startNewActivity

class MainFragment: DaggerFragment(R.layout.fragment_main),
    NavigationBarView.OnItemSelectedListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        bottomNavigationView.background = null
        anchor.background = null
        openHistoryFragment()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> openHistoryFragment()
            R.id.settings -> openSettingsFragment()
        }
        return true
    }

    private fun initButtons() {
        float_scan_button.setOnClickListener{
            startScanActivity()
        }
        bottomNavigationView.setOnItemSelectedListener(this)
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
        activity?.supportFragmentManager?.let {
            addFragment(it, R.id.content_container, HistoryFragment.newInstance(), false)
        }
        toolbar.title = getString(R.string.toolbar_text_history)
    }

    private fun openSettingsFragment() {
        activity?.supportFragmentManager?.let {
            addFragment(it, R.id.content_container, SettingsFragment.newInstance(), false)
        }
        toolbar.title = getString(R.string.toolbar_text_settings)
    }
}