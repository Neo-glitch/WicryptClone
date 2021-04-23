package com.neo.wicryptclone.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.neo.wicryptclone.R
import com.neo.wicryptclone.databinding.ActivityMainBinding
import com.neo.wicryptclone.ui.navactivities.MyDevicesActivity
import com.neo.wicryptclone.ui.navactivities.ReferralsActivity
import com.neo.wicryptclone.ui.navactivities.TransactionsActivity
import com.neo.wicryptclone.utilities.PagerAdapter

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var mToggle: ActionBarDrawerToggle
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initToolbar()
        initViewPager()
        initNavViewAndDrawer()
    }

    private fun initNavViewAndDrawer() {
        mDrawerLayout = binding.drawer

        mToolbar.navigationIcon =resources.getDrawable(R.drawable.ic_nav_icon, null)
        mToggle = ActionBarDrawerToggle(
            this, mDrawerLayout, mToolbar,
            R.string.open,
            R.string.close
        )
        mToggle.drawerArrowDrawable.color = resources.getColor(android.R.color.white, null)
        mDrawerLayout.addDrawerListener(mToggle)

        mToggle.isDrawerIndicatorEnabled = true
        mToggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

    }

    private fun initViewPager() {
        val viewPager = binding.layoutContent.viewPager
        viewPager.adapter = PagerAdapter(this)

        val tabLayout = binding.layoutContent.tabLayout
        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0 -> tab.text ="Home"
                    1 -> tab.text = "Available Wifi"
                    2 -> tab.text = "Connected Devices"
                }
            }
        })
        tabLayoutMediator.attach()
    }

    private fun initToolbar() {
        mToolbar = binding.layoutContent.toolbar
        setSupportActionBar(mToolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.transactions -> {
                startActivity(Intent(this, TransactionsActivity::class.java))
                true
            } else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.transactions -> {
                startActivity(Intent(this, TransactionsActivity::class.java))
                true
            }
            R.id.referrals ->{
                startActivity(Intent(this, ReferralsActivity::class.java))
                true
            }
            R.id.my_devices -> {
                startActivity(Intent(this, MyDevicesActivity::class.java))
                true
            }
            R.id.withdrawals -> {
                true
            }
            R.id.available_tokens -> {
                true
            }
            R.id.router_login -> {
                true
            }
            R.id.support_chat -> {
                true
            }
            R.id.settings -> {
                true
            }
            R.id.sign_out ->{
                true
            }
            else -> true
        }
    }

    override fun onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }
}