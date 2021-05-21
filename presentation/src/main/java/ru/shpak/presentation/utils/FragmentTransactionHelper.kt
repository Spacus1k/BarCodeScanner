package ru.shpak.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun replaceFragment(
    fragmentTransaction: FragmentTransaction?,
    containerViewId: Int,
    fragment: Fragment
) {
    fragmentTransaction?.replace(containerViewId, fragment)
    fragmentTransaction?.addToBackStack(null)
    fragmentTransaction?.commit()
}