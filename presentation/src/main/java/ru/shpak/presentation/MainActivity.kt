package ru.shpak.presentation

import android.os.Bundle
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.utils.Router
import ru.shpak.presentation.viewModels.SharedPrefViewModel
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    companion object {
        private const val MIN_NUMBER_OF_FRAGMENTS_IN_BACKSTACK = 2
    }

    @Inject
    lateinit var mainViewModel: SharedPrefViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.loadThemeMode(this)

        Router(this, R.id.activity_fragment_container).openFragment(
            MainFragment.newInstance(),
            isAddToBackStack = false
        )
    }

    override fun onBackPressed() =
        if (supportFragmentManager.fragments.size == MIN_NUMBER_OF_FRAGMENTS_IN_BACKSTACK) {
            finishAffinity()
        } else {
            super.onBackPressed()
        }
}