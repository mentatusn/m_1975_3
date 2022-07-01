package com.gb.m_1975_3.view.ux

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityUxBinding

class UXActivity : AppCompatActivity() {
    lateinit var binding: ActivityUxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        binding = ActivityUxBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationViewUX.setOnItemSelectedListener {
            when(it.itemId){
                R.id.fragment_ux_text->{
                    navigateTo(TextUXFragment())
                }
                R.id.fragment_ux_button->{
                    navigateTo(ButtonUXFragment())
                }
                R.id.fragment_ux_tutorial->{
                    navigateTo(TutorialButtonUXFragment.newInstance())
                }
            }
            true
        }

        binding.bottomNavigationViewUX.selectedItemId = R.id.fragment_ux_text
    }

    private fun navigateTo(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }

}