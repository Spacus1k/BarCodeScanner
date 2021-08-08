package ru.shpak.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.shpak.presentation.R
import ru.shpak.presentation.ScanActivity
import ru.shpak.presentation.utils.addFragment
import ru.shpak.presentation.utils.startNewActivity
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class MainFragment : DaggerFragment(R.layout.fragment_main),
    BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        bottomNavigationView.background = null
        openHistoryFragment()
    }

    private fun initButtons() {
        float_scan_button.setOnClickListener{
            startScanActivity()
        }
        //Todo change
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> openHistoryFragment()
            R.id.settings -> openSettingsFragment()
        }
        return true
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