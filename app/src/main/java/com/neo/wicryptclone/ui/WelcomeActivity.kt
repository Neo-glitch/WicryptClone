package com.neo.wicryptclone.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import kotlinx.coroutines.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        CoroutineScope(Dispatchers.Main).launch {
            delay(300)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
        }
    }
}