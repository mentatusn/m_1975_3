package com.gb.m_1975_3.view.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.m_1975_3.R

class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var layout = R.layout.fragment_earth
        //TODO HW избавиться от R.layout.fragment_earth R.layout.fragment_mars R.layout.fragment_system через  .setImageResource()
        arguments?.let {
            layout = when (it.getInt(BUNDLE_KEY)) {
                EARTH_FRAGMENT -> R.layout.fragment_earth
                MARS_FRAGMENT -> R.layout.fragment_mars
                SYSTEM_FRAGMENT -> R.layout.fragment_system
                else -> R.layout.fragment_earth
            }
        }
        return inflater.inflate(layout, container, false)
    }

    companion object {
        internal const val EARTH_FRAGMENT = 0
        internal const val MARS_FRAGMENT = 1
        internal const val SYSTEM_FRAGMENT = 2
        private const val BUNDLE_KEY = "key"

        @JvmStatic
        fun newInstance(type: Int): Fragment {
            return BaseFragment().apply {
                arguments = Bundle().apply {
                    putInt(BUNDLE_KEY, type)
                }
            }
        }
    }
}
