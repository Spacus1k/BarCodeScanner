package ru.shpak.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun addFragment(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    isAddToBackStack: Boolean = true
) {
    val transaction = fragmentManager
        .beginTransaction()
        .add(containerViewId, fragment, fragment.tag)

    if (isAddToBackStack) transaction.addToBackStack(fragment.tag)

    transaction.commit()
}