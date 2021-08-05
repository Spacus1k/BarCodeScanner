package ru.shpak.presentation

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import ru.shpak.presentation.base.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    companion object {
        private const val SPLASH_SCREEN_SHOW_TIME = 500L
    }

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserves()
        viewModel.createDelay(SPLASH_SCREEN_SHOW_TIME)
    }

    private fun initObserves() {
        with(viewModel) {
            iconId.observe(this@SplashActivity) { icon ->
                appIcon.setImageResource(icon)
            }
            timerDone.observe(this@SplashActivity) { isDone ->
                if (isDone) {
                    startMainActivity()
                }
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}