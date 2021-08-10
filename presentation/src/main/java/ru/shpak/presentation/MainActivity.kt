package ru.shpak.presentation

import android.os.Bundle
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.utils.addFragment
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject
    lateinit var mainViewModel: SharedPrefViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openMainFragment()
             mainViewModel.loadThemeMode(this)
    }

    private fun openMainFragment() {
        addFragment(
            this.supportFragmentManager,
            R.id.fragment_container,
            MainFragment.newInstance(),
            false
        )
    }

    //TODO rewrite this function
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}