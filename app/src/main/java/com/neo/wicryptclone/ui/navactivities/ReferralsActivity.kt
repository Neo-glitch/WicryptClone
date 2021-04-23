package com.neo.wicryptclone.ui.navactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityReferralsBinding

class ReferralsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReferralsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferralsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Referrals"
    }
}