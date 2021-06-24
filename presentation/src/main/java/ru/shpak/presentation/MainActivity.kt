package ru.shpak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.fragments.MainFragment
import ru.shpak.presentation.utils.replaceFragment

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openMainFragment()
    }

    private fun openMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                MainFragment.newInstance(),
                MainFragment.MAIN_FRAGMENT_TAG
            ).commit()
    }

    //TODO fix this function
    override fun onBackPressed() {
        val isMainFragmentOpened =
            supportFragmentManager.findFragmentByTag(MainFragment.MAIN_FRAGMENT_TAG) != null
        if (isMainFragmentOpened) {
            finish()
            super.onBackPressed()
        }
    }
}