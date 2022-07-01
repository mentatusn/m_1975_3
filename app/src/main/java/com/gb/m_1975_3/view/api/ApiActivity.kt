package com.gb.m_1975_3.view.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityApiBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ApiActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
         binding.tabLayout.setupWithViewPager(binding.viewPager)*/
        binding.viewPager.adapter = ViewPager2Adapter(this)

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    tab.text = when (position) {
                        BaseFragment.EARTH_FRAGMENT -> "Earth"
                        BaseFragment.MARS_FRAGMENT -> "Mars"
                        BaseFragment.SYSTEM_FRAGMENT -> "System"
                        else -> "Earth"
                    }

                    tab.icon = when (position) {
                        BaseFragment.EARTH_FRAGMENT -> resources.getDrawable(R.drawable.ic_earth)
                        BaseFragment.MARS_FRAGMENT -> resources.getDrawable(R.drawable.ic_mars)
                        BaseFragment.SYSTEM_FRAGMENT -> resources.getDrawable(R.drawable.ic_system)
                        else -> resources.getDrawable(R.drawable.ic_earth)
                    }
                }
            }).attach()

    }
}
