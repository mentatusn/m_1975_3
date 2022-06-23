package com.gb.m_1975_3.view.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


private const val ADAPTER_SIZE = 100
class ViewPagerAdapter(private val fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager) {
    //val fragments = arrayOf(MarsFragment(),SystemFragment(),EarthFragment())
    override fun getCount(): Int {
        //return fragments.size
        return ADAPTER_SIZE
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            BaseFragment.EARTH_FRAGMENT -> "Earth"
            BaseFragment.MARS_FRAGMENT -> "Mars"
            BaseFragment.SYSTEM_FRAGMENT -> "System"
            else -> "Earth"
        }
    }

    override fun getItem(position: Int): Fragment {
        return BaseFragment.newInstance(position)
    }
}