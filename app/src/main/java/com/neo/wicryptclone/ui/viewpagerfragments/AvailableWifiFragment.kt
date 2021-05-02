package com.neo.wicryptclone.ui.viewpagerfragments


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.FragmentAvailableWifiBinding


class AvailableWifiFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: FragmentAvailableWifiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAvailableWifiBinding.inflate(inflater, container, false)
        binding.swipeRefreshLayout.setOnRefreshListener(this)

        initViewListeners()
        return binding.root
    }

    private fun initViewListeners() {
        binding.switchToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.switchText.text = "Turn off wifi to stop seeing available connections"
                binding.ivWifi.visibility = View.INVISIBLE
                binding.tvWifi.visibility = View.INVISIBLE
                binding.ivBox.visibility = View.VISIBLE
                binding.tvBox.visibility = View.VISIBLE
            } else {
                binding.switchText.text = "Turn on wifi to see all available connections"
                binding.ivWifi.visibility = View.VISIBLE
                binding.tvWifi.visibility = View.VISIBLE
                binding.ivBox.visibility = View.INVISIBLE
                binding.tvBox.visibility = View.INVISIBLE
            }
        }
    }


    override fun onRefresh() {
        binding.switchToggle.isChecked = true
        val countDownTimer = object : CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
        countDownTimer.start()

    }
}