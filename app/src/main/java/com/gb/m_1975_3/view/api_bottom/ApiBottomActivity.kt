package com.gb.m_1975_3.view.api_bottom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityApiBinding
import com.gb.m_1975_3.databinding.ActivityApiBottomBinding
import com.gb.m_1975_3.view.api.*
import com.google.android.material.badge.BadgeDrawable

class ApiBottomActivity : AppCompatActivity() {
    lateinit var binding: ActivityApiBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        setupNavigation()
    }

    private fun setupNavigation() {
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_view_mars

        val badge = binding.bottomNavigationView.getOrCreateBadge(R.id.action_bottom_view_system)
        badge.number = 1000000
        badge.maxCharacterCount = 7
        badge.badgeGravity = BadgeDrawable.BOTTOM_START
        //badge.clearNumber()
        //binding.bottomNavigationView.removeBadge(R.id.action_bottom_view_system)
    }

    private fun init() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EarthFragment()).commit()
                    true
                }
                R.id.action_bottom_view_mars -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MarsFragment()).commit()
                    true
                }
                R.id.action_bottom_view_system -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SystemFragment()).commit()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}
