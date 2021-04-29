package com.neo.wicryptclone.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.neo.wicryptclone.databinding.ActivityRouterLoginBinding


class RouterLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRouterLoginBinding
    private var counter: Int = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouterLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Router Login"

        initProgressBar()

        binding.btnAvailableNetworks.setOnClickListener {
            goToAvailableWifiFragment()
        }
    }

    private fun goToAvailableWifiFragment() {
        setResult(Activity.RESULT_OK)
        onBackPressed()
    }

    private fun initProgressBar() {
        val countDownTimer = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                binding.textViewProgress.text = counter.toString()
                binding.progressBar.progress++
                counter--
            }

            override fun onFinish() {
                counter = 30
                binding.progressBar.progress = 0
                initProgressBar()
            }
        }
        countDownTimer.start()
    }


}