package com.neo.wicryptclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}