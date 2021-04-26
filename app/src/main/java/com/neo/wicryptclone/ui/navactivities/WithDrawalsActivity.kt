package com.neo.wicryptclone.ui.navactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityWithdrawalsBinding


class WithDrawalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWithdrawalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithdrawalsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Withdrawals"
    }
}