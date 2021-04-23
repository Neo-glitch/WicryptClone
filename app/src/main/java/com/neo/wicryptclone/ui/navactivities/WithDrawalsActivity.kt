package com.neo.wicryptclone.ui.navactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityWithDrawalsBinding

class WithDrawalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWithDrawalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithDrawalsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Withdrawals"
    }
}