package ru.shpak.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import dagger.android.support.DaggerFragment
import ru.shpak.domain.utils.ScanMode
import ru.shpak.domain.utils.Theme
import ru.shpak.presentation.R
import ru.shpak.presentation.databinding.FragmentSettingsBinding
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class SettingsFragment : DaggerFragment(R.layout.fragment_settings), View.OnClickListener {

    companion object {
        fun newInstance() = SettingsFragment()

        private const val TAG = "confirmationDialog"
    }

    @Inject
    lateinit var sharedPrefViewModel: SharedPrefViewModel

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        initButtons()
        initSwitch()
        checkPrefModes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        activity?.let {
            when (view) {
                binding.deleteButton -> showDialog(it)
                binding.darkModeCheckBox -> checkBoxAction(it, binding.darkModeCheckBox.isChecked)
            }
        }
    }

    private fun initButtons() {
        binding.deleteButton.setOnClickListener(this)
        binding.darkModeCheckBox.setOnClickListener(this)
    }

    private fun initSwitch() {
        activity?.let { activity ->
            binding.switchMaterial.setOnCheckedChangeListener { _, isChecked ->
                sharedPrefViewModel.saveScanMode(
                    activity.application,
                    if (isChecked) ScanMode.NONSTOP else ScanMode.STOP
                )
            }
        }
    }

    private fun checkPrefModes() {
        activity?.let {
            binding.switchMaterial.isChecked =
                sharedPrefViewModel.getScanMode(it.application) == ScanMode.NONSTOP

            binding.darkModeCheckBox.isChecked = sharedPrefViewModel.checkThemeMode(it) == Theme.DARK
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
