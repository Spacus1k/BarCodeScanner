package ru.shpak.presentation

import android.os.Bundle
import ru.shpak.presentation.base.BaseActivity

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    companion object{
       private const val SPLASH_SCREEN_SHOW_TIME = 200L
    }

    private val viewModel:SplashViewModel = SplashViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private  fun initObserves(){
        with(viewModel){
            iconId.observe(this@SplashActivity){ icon - >
                    appIcon
            }
        }
    }
}