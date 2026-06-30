package ru.shpak.presentation

import android.content.Intent
import android.os.Bundle
import ru.shpak.presentation.base.BaseActivity
import ru.shpak.presentation.databinding.ActivitySplashBinding
import ru.shpak.presentation.viewModels.SplashViewModel
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    companion object {
        private const val SPLASH_SCREEN_SHOW_TIME = 2000L
    }

    @Inject
    lateinit var viewModel: SplashViewModel

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initObserves()
        viewModel.createDelay(SPLASH_SCREEN_SHOW_TIME)
    }

    private fun initObserves() {
        with(viewModel) {
            iconId.observe(this@SplashActivity) { icon ->
                binding.appIcon.setImageResource(icon)
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
