package com.neo.wicryptclone.utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.neo.wicryptclone.ui.viewpagerfragments.AvailableWifiFragment
import com.neo.wicryptclone.ui.viewpagerfragments.ConnectedDevicesFragment
import com.neo.wicryptclone.ui.viewpagerfragments.HomeFragment

class PagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> AvailableWifiFragment()
            2 -> ConnectedDevicesFragment()
            else -> null!!
        }
    }

}