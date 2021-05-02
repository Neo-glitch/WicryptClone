package com.neo.wicryptclone.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityShareWCBinding

class ShareWCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShareWCBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareWCBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.title = "Share Wicrypt Credit"

        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        binding.btnShare.setOnClickListener {
            hideKeyboard(it)
            if(binding.etAmount.text.isNotEmpty() && binding.etEmail.text.isNotEmpty()){
                showProgressBar()
            } else{
                Toast.makeText(this, "All fields must be filled before WC can be shared", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showProgressBar() {
        binding.progressLayout.visibility = View.VISIBLE
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

        val countDownTimer = object : CountDownTimer(3500, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                binding.progressLayout.visibility = View.INVISIBLE
                window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                Toast.makeText(this@ShareWCActivity, "WC shared successfully", Toast.LENGTH_SHORT).show()
            }
        }
        countDownTimer.start()
    }
}