package com.gb.m_1975_3.view.ux

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.R
import com.gb.m_1975_3.view.MainActivity


class SplashActivity : AppCompatActivity() { //TODO HW single-activity пытаемся сохранить
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        setContentView(R.layout.activity_splash)


        findViewById<ImageView>(R.id.image_view).animate().rotationBy(1080f).setDuration(4000L)
            .start()

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 4000L)
    }
}