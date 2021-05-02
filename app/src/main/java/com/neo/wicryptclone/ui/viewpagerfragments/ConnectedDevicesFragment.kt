package com.neo.wicryptclone.ui.viewpagerfragments


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.FragmentConnectedDevicesBinding

class ConnectedDevicesFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: FragmentConnectedDevicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConnectedDevicesBinding.inflate(inflater, container, false)
        binding.swipeRefreshLayout.setOnRefreshListener(this)
        return binding.root
    }

    override fun onRefresh() {
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