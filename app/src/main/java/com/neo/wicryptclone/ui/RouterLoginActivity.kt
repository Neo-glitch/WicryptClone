package com.neo.wicryptclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityRouterLoginBinding

class RouterLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRouterLoginBinding
    private var prog: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRouterLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Router Login"

//        updateProgressBar()

//        binding.btnIncrease.setOnClickListener {
//            if(prog<= 90){
//                prog += 10
//                updateProgressBar()
//            }
//        }
//        binding.btnDecrease.setOnClickListener {
//            if(prog>= 10){
//                prog -= 10
//                updateProgressBar()
//            }
//        }
    }

//    private fun updateProgressBar(){
//        binding.progressBar.progress = prog
//        binding.textViewProgress.text = "$prog"
//    }
}