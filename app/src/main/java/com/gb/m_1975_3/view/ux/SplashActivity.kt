package com.gb.m_1975_3.view.ux

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.R

@SuppressLint("CustomSplashScreen") // Android 12
class SplashActivity : AppCompatActivity() { //TODO HW single-activity пытаемся сохранить
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}