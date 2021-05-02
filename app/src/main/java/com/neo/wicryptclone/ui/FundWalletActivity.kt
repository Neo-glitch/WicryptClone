package com.neo.wicryptclone.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        binding.cvCard.setOnClickListener {
            if(mBankRadioBtnChecked){
                binding.radioBtnBankTransfer.isChecked = false
                mBankRadioBtnChecked = false
            }
            mCardRadioBtnChecked = true
            binding.radioBtnCard.isChecked = true
        }

        binding.cvBank.setOnClickListener {
            if(mCardRadioBtnChecked){
                binding.radioBtnCard.isChecked = false
                mCardRadioBtnChecked = false
            }
            mBankRadioBtnChecked = true
            binding.radioBtnBankTransfer.isChecked = true
        }

        binding.btnAddFund.setOnClickListener {
            if(mBankRadioBtnChecked){
                showBottomSheetDialog()
            } else if(mCardRadioBtnChecked){
                showFundAccountDialog()
            }
        }
    }


    private fun showBottomSheetDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog)

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)

        initDialogClickListeners(dialog)
    }

    private fun initDialogClickListeners(dialog: Dialog) {
        val positiveButton = dialog.findViewById<Button>(R.id.btn_upgrade)
        val negativeButton = dialog.findViewById<TextView>(R.id.tv_cancel)

        negativeButton.setOnClickListener{dialog.dismiss()}
        positiveButton.setOnClickListener {
            Toast.makeText(this, "upgrade coming soon", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }

    private fun showFundAccountDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_fund_account)

        val positiveBtn = dialog.findViewById<Button>(R.id.btn_fund)
        val negativeBtn = dialog.findViewById<Button>(R.id.btn_cancel)

        positiveBtn.setOnClickListener {
            Toast.makeText(this, "Account funded", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        negativeBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}