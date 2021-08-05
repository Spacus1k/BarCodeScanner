package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.shpak.presentation.R
import ru.shpak.presentation.SharedPrefViewModel

class SettingsFragment : Fragment() {

    private val sharedPrefViewModel = SharedPrefViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, content_container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initThemeListener()
        checkDarkMode()
    }

    private fun initThemeListener() {
        dark_mode_check_box.setOnClickListener {
            activity?.let {
                when (dark_mode_check_box.isChecked) {
                    true -> turnOnDarkMode()
                    false -> turnOffDarkMode()
                }
            }
        }
    }

    private fun turnOnDarkMode() {
        activity?.let {
            sharedPrefViewModel.saveThemeMode(it, true)
            it.recreate()
        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun turnOffDarkMode() {
        activity?.let {
            sharedPrefViewModel.saveThemeMode(it, false)

        }
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun checkDarkMode() {
        activity?.let {
            if (sharedPrefViewModel.checkDarkMode(it)) {
                dark_mode_check_box.isChecked = true
            }
        }
    }
}