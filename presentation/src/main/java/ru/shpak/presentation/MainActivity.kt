package ru.shpak.presentation

import android.os.Bundle
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.utils.addFragment

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val sharedPrefViewModel = SharedPrefViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPrefViewModel.loadThemeMode(this)
        super.onCreate(savedInstanceState)
        openMainFragment()
    }

    private fun openMainFragment() {
        addFragment(
            this.supportFragmentManager,
            R.id.fragment_container,
            MainFragment.newInstance()
        )
    }


    //TODO rewrite this function
    override fun onBackPressed() = if (supportFragmentManager.fragments.size == 1) {
        finishAndRemoveTask()
    } else {
        super.onBackPressed()
    }

}