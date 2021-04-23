package com.neo.wicryptclone.ui.navactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityMyDevicesBinding

class MyDevicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyDevicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyDevicesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "My Devices"
    }
}