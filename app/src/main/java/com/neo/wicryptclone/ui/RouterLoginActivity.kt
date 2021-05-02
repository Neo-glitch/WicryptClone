package com.neo.wicryptclone.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.neo.wicryptclone.databinding.ActivityRouterLoginBinding
import com.neo.wicryptclone.viewmodel.RouterLoginViewModel
import kotlin.random.Random


class RouterLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRouterLoginBinding
    private var counter: Int = 30
    private lateinit var mRouterCode: String
    private val mViewModel by lazy {
        ViewModelProvider(this)[RouterLoginViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouterLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Router Login"

        initProgressBar()

        // gen random
        genRandomNumber()

        initOnClickListeners()

    }

    private fun genRandomNumber() {
        mViewModel.genRandomNumber()
        mViewModel.mRouterCode.observe(this, Observer {routerCode ->
            binding.routerCode.text = routerCode
        })
    }

    private fun initOnClickListeners() {
        binding.btnAvailableNetworks.setOnClickListener {
            goToAvailableWifiFragment()
        }

        binding.ivCopyEmail.setOnClickListener {
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
        }

        binding.ivCopyCode.setOnClickListener {
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
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
                genRandomNumber()
            }
        }
        countDownTimer.start()
    }


}