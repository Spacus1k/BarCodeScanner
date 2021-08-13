package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.shpak.domain.utils.ScanMode
import ru.shpak.domain.utils.Theme
import ru.shpak.presentation.R
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class SettingsFragment : DaggerFragment(R.layout.fragment_settings), View.OnClickListener {

    companion object {
        fun newInstance() = SettingsFragment()

        private const val TAG = "confirmationDialog"
    }

    @Inject
    lateinit var sharedPrefViewModel: SharedPrefViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        initSwitch()
        checkPrefModes()
    }

    override fun onClick(view: View?) {
        activity?.let {
            when (view) {
                delete_button -> showDialog(it)
                dark_mode_check_box -> checkBoxAction(it, dark_mode_check_box.isChecked)
            }
        }
    }

    private fun initButtons() {
        delete_button.setOnClickListener(this)
        dark_mode_check_box.setOnClickListener(this)
    }

    private fun initSwitch() {
        activity?.let { activity ->
            switch_material.setOnCheckedChangeListener { _, isChecked ->
                sharedPrefViewModel.saveScanMode(
                    activity.application,
                    if (isChecked) ScanMode.NONSTOP else ScanMode.STOP
                )
            }
        }
    }

    private fun checkPrefModes() {
        activity?.let {

            switch_material.isChecked =
                sharedPrefViewModel.getScanMode(it.application) == ScanMode.NONSTOP

            dark_mode_check_box.isChecked = sharedPrefViewModel.checkThemeMode(it) == Theme.DARK
        }
    }

    private fun checkBoxAction(activity: FragmentActivity, checked: Boolean) {
        sharedPrefViewModel.setThemeMode(
            activity,
            if (checked) Theme.DARK else Theme.LIGHT
        )
    }

    private fun showDialog(activity: FragmentActivity) {
        val dialogFragment = ConfirmationDialogFragment.newInstance()
        dialogFragment.show(activity.supportFragmentManager, TAG)
    }
}