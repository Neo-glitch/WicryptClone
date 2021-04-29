package com.neo.wicryptclone.ui.viewpagerfragments


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.FragmentHomeBinding
import com.neo.wicryptclone.ui.FundWalletActivity
import com.neo.wicryptclone.ui.RouterLoginActivity
import com.neo.wicryptclone.ui.ShareWCActivity


class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mDialog: Dialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initOnClickListeners()

        return binding.root
    }

    private fun initOnClickListeners() {
        binding.btnSetRate.setOnClickListener(this)
        binding.ivRefresh.setOnClickListener(this)

        binding.ivFundWallet.setOnClickListener(this)
        binding.ivShareWc.setOnClickListener(this)
        binding.ivWithdraw.setOnClickListener(this)
        binding.ivRouterLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_set_rate -> {
                showBillingRateDialog()
            }
            R.id.iv_refresh -> {
                showProgressBar()
            }
            R.id.iv_fund_wallet ->{
                requireContext().startActivity(Intent(requireContext(), FundWalletActivity::class.java))
            }
            R.id.iv_share_wc ->{
                requireContext().startActivity(Intent(requireContext(), ShareWCActivity::class.java))
            }
            R.id.iv_withdraw ->{
                Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_router_login ->{
                requireContext().startActivity(Intent(requireContext(), RouterLoginActivity::class.java))
            }
        }
    }

    private fun showProgressBar() {
        binding.progressLayout.visibility = View.VISIBLE

        // makes buttons on view to be interacted with
        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        val countDownTimer = object : CountDownTimer(3500, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                binding.progressLayout.visibility = View.INVISIBLE
                requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                Toast.makeText(requireContext(), "Updated Summary", Toast.LENGTH_SHORT).show()
            }
        }
        countDownTimer.start()
    }

    private fun showBillingRateDialog() {
        mDialog = Dialog(requireContext())
        mDialog.setContentView(R.layout.dialog_billing_rate)

        val positiveBtn = mDialog.findViewById<Button>(R.id.btn_update)
        val negativeBtn = mDialog.findViewById<TextView>(R.id.txt_cancel)

//        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        positiveBtn.setOnClickListener {
            Toast.makeText(requireContext(), "positive button clicked", Toast.LENGTH_SHORT).show()
        }
        negativeBtn.setOnClickListener {
            mDialog.dismiss()
        }
        mDialog.show()

    }
}