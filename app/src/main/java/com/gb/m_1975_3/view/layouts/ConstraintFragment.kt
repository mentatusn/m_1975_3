package com.gb.m_1975_3.view.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.m_1975_3.databinding.FragmentConstraintBinding

class ConstraintFragment: Fragment() {
    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!

    var flag = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btn0.setOnClickListener { flag = !flag; if(flag) {binding.group1.visibility = View.GONE}else {binding.group1.visibility = View.VISIBLE} }

        //binding.group1.visibility = View.INVISIBLE
    }
    companion object {
        @JvmStatic
        fun newInstance() = ConstraintFragment()
    }
}
