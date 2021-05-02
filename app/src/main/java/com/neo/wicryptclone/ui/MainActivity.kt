package com.neo.wicryptclone.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.neo.wicryptclone.R
import com.neo.wicryptclone.SettingsActivity
import com.neo.wicryptclone.databinding.ActivityMainBinding
import com.neo.wicryptclone.ui.navactivities.*
import com.neo.wicryptclone.utilities.PagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    companion object {
        private val ROUTER_ACTIVITY = 1
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var mToggle: ActionBarDrawerToggle
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mToolbar: Toolbar
    private lateinit var mViewPager: ViewPager2


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

        mToolbar.navigationIcon = resources.getDrawable(R.drawable.ic_nav_icon, null)
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
        mViewPager = binding.layoutContent.viewPager
        mViewPager.adapter = PagerAdapter(this)

        val tabLayout = binding.layoutContent.tabLayout
        val tabLayoutMediator = TabLayoutMediator(
            tabLayout,
            mViewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    when (position) {
                        0 -> tab.text = "Home"
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
        return when (item.itemId) {
            R.id.transactions -> {
                startActivity(Intent(this, TransactionsActivity::class.java))
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return when (item.itemId) {
            R.id.transactions -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, TransactionsActivity::class.java))
                }
                true
            }
            R.id.referrals -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, ReferralsActivity::class.java))
                }
                true
            }
            R.id.my_devices -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, MyDevicesActivity::class.java))
                }
                true
            }
            R.id.withdrawals -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, WithDrawalsActivity::class.java))
                }
                true
            }
            R.id.available_tokens -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, AvailableTokensActivity::class.java))
                }
                true
            }
            R.id.router_login -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivityForResult(
                        Intent(this@MainActivity, RouterLoginActivity::class.java),
                        ROUTER_ACTIVITY
                    )
                }
                true
            }
            R.id.support_chat -> {
                true
            }
            R.id.settings -> {
                CoroutineScope(Dispatchers.Main).launch {
                    delay(270)
                    startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                }
                true
            }
            R.id.sign_out -> {
                true
            }
            else -> true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ROUTER_ACTIVITY && resultCode == Activity.RESULT_OK) {
            mViewPager.currentItem = 1
        }
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else if (mViewPager.currentItem > 0) {
            mViewPager.currentItem = mViewPager.currentItem - 1
        } else {
            super.onBackPressed()
        }
    }
}