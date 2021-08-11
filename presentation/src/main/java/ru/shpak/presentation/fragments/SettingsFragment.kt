package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.shpak.domain.utils.Theme
import ru.shpak.presentation.R
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class SettingsFragment : DaggerFragment(R.layout.fragment_settings) {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    @Inject
    lateinit var sharedPrefViewModel: SharedPrefViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkDarkMode()
        initButtons()
        initThemeListener()
    }

    private fun initButtons() {
        delete_button.setOnClickListener {
            val dialogFragment = ConfirmationDialogFragment.newInstance()
            activity?.let {
                dialogFragment.show(it.supportFragmentManager, "confirmationDialog")
            }
        }
    }

    private fun initThemeListener() {
        dark_mode_check_box.setOnClickListener {
            activity?.let {
                when (dark_mode_check_box.isChecked) {
                    true -> sharedPrefViewModel.setThemeMode(it, Theme.DARK)
                    false -> sharedPrefViewModel.setThemeMode(it, Theme.LIGHT)
                }
            }
        }
    }

    private fun checkDarkMode() {
        activity?.let {
            if (sharedPrefViewModel.checkThemeMode(it) == Theme.DARK) {
                dark_mode_check_box.isChecked = true
            }
        }
    }
}