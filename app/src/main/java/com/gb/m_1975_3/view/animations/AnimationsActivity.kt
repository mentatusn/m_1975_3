package com.gb.m_1975_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.service.autofill.Validators.or


import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBinding
    var flag = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val changeBounds = ChangeBounds()
            val path = ArcMotion()
            path.maximumAngle = 90F
            changeBounds.setPathMotion(path)
            changeBounds.duration = 3000L
            TransitionManager.beginDelayedTransition(binding.root,changeBounds)
            flag = !flag
            if(flag){
                val params = (binding.button.layoutParams as FrameLayout.LayoutParams)
                params.gravity = Gravity.TOP or Gravity.START
                binding.button.layoutParams = params
            }else{
                val params = (binding.button.layoutParams as FrameLayout.LayoutParams)
                params.gravity = Gravity.BOTTOM or Gravity.RIGHT
                binding.button.layoutParams = params
            }
        }

    }




}
