package com.gb.m_1975_3.view.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.gb.m_1975_3.databinding.FragmentCoordinatorBinding
import com.gb.m_1975_3.view.layouts.behaviors.FadeBehavior

class CoordinatorFragment : Fragment() {
    private var _binding: FragmentCoordinatorBinding? = null
    private val binding: FragmentCoordinatorBinding
        get() = _binding!!

    var flag = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (binding.btn.layoutParams as CoordinatorLayout.LayoutParams).behavior =
            FadeBehavior(requireContext())
    }

    companion object {
        @JvmStatic
        fun newInstance() = CoordinatorFragment()
    }
}
