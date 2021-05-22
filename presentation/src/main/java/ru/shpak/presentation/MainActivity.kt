package ru.shpak.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.shpak.presentation.utils.replaceFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(
            supportFragmentManager,
            R.id.fragment_container,
            MainFragment.newInstance(),
            true
        )
    }
}