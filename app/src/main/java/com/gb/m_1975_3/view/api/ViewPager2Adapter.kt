package com.gb.m_1975_3.view.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


private const val ADAPTER_SIZE = 100
class ViewPager2Adapter(private val fragmentManager: FragmentActivity):FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int {
        return ADAPTER_SIZE
    }

    override fun createFragment(position: Int): Fragment {
        return BaseFragment.newInstance(position)
    }

}