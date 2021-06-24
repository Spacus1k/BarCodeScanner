package ru.shpak.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity(@LayoutRes private val layoutId : Int = 0) : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(layoutId != 0) setContentView(layoutId)
    }
}