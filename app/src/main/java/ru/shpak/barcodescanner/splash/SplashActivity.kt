package ru.shpak.barcodescanner.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import ru.shpak.barcodescanner.App
import ru.shpak.barcodescanner.R
import ru.shpak.presentation.MainActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_SCREEN_SHOW_TIME = 5000L
    }

    @Inject
    lateinit var viewModel: SplashViewModel

    init {
        App.getComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initObservers()
        viewModel.createDelay(SPLASH_SCREEN_SHOW_TIME)
    }

    private fun initObservers() {
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