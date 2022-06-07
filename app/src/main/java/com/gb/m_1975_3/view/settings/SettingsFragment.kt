package com.gb.m_1975_3.view.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.FragmentPictureOfTheDayBinding
import com.gb.m_1975_3.databinding.FragmentSettingsBinding
import com.gb.m_1975_3.view.MainActivity
import com.gb.m_1975_3.view.pictureoftheday.BottomNavigationDrawerFragment
import com.gb.m_1975_3.viewmodel.AppState
import com.gb.m_1975_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.util.*


class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chip1.setOnClickListener {
            Toast.makeText(context, "setOnClickListener", Toast.LENGTH_SHORT).show()
        }
        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->  }
        
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment()
    }
}