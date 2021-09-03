package ru.shpak.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class Router constructor(private val activity: FragmentActivity, private val containerViewId: Int) {

    fun openFragment(
        fragment: Fragment,
        container: Int = containerViewId,
        isAddToBackStack: Boolean = true
    ) {
        val transaction = activity.supportFragmentManager
            .beginTransaction()
            .replace(container, fragment, fragment.tag)

        if (isAddToBackStack) transaction.addToBackStack(fragment.tag)

        transaction.commit()
    }

    fun removeFragment(
        fragment: Fragment,
    ) {
        val transaction = activity.supportFragmentManager
            .beginTransaction()
            .remove(fragment)

        transaction.commit()
    }
}