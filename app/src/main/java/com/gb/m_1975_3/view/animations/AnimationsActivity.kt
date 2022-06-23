package com.gb.m_1975_3.view.animations

import android.graphics.Rect
import android.os.Bundle


import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView.setOnClickListener {imageView ->
            flag = !flag

            val changeBounds = ChangeBounds()
            val changeImageTransform = ChangeImageTransform()
            val transitionSet = TransitionSet()
            transitionSet.addTransition(changeBounds)
            transitionSet.addTransition(changeImageTransform)
            TransitionManager.beginDelayedTransition(binding.root,transitionSet)
            if(flag){
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                (binding.imageView.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.CENTER
                (binding.imageView.layoutParams as FrameLayout.LayoutParams).height = FrameLayout.LayoutParams.MATCH_PARENT
            }else{
                binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
                (binding.imageView.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.TOP
                (binding.imageView.layoutParams as FrameLayout.LayoutParams).height = FrameLayout.LayoutParams.WRAP_CONTENT
            }
        }

    }




}
