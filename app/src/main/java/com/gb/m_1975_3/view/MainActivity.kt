package com.gb.m_1975_3.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.R
import com.gb.m_1975_3.view.pictureoftheday.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(Parameters.getInstance().theme)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
        }

    }
}