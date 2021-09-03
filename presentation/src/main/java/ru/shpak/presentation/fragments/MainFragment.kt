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
import ru.shpak.presentation.utils.Router
import ru.shpak.presentation.utils.startNewActivity

class MainFragment : DaggerFragment(R.layout.fragment_main),
    NavigationBarView.OnItemSelectedListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var router:Router? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        router = activity?.let { Router(it, R.id.content_container) }
        router?.openFragment(HistoryFragment.newInstance())
        setFragmentTitle(HistoryFragment::class.java.simpleName)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history -> {
                router?.openFragment(HistoryFragment.newInstance(), isAddToBackStack = false)
                setFragmentTitle(HistoryFragment::class.java.simpleName)
            }

            R.id.settings -> {
                router?.openFragment(SettingsFragment.newInstance(), isAddToBackStack = false)
                setFragmentTitle(SettingsFragment::class.java.simpleName)
            }
        }
        return true
    }

    private fun initButtons() {
        float_scan_button.setOnClickListener {
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
    private fun setFragmentTitle(fragmentName: String) {
        toolbar.title = getString(
            when (fragmentName) {
                HistoryFragment::class.java.simpleName -> R.string.toolbar_text_history
                SettingsFragment::class.java.simpleName -> R.string.toolbar_text_settings
                else -> return
            }
        )
    }
}