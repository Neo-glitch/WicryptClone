package com.neo.wicryptclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityFundWalletBinding

class FundWalletActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFundWalletBinding

    private var mCardRadioBtnChecked = false
    private var mBankRadioBtnChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundWalletBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Fund Wallet"

        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        binding.radioBtnCard.setOnClickListener {
            if(mBankRadioBtnChecked){
                binding.radioBtnBankTransfer.isChecked = false
                mBankRadioBtnChecked = false
            }
            mCardRadioBtnChecked = true
        }

        binding.radioBtnBankTransfer.setOnClickListener {
            if(mCardRadioBtnChecked){
                binding.radioBtnCard.isChecked = false
                mCardRadioBtnChecked = false
            }
            mBankRadioBtnChecked = true
        }
    }
}