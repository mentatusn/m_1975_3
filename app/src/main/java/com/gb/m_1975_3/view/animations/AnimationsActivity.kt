package com.gb.m_1975_3.view.animations

import android.os.Bundle
import android.os.CountDownTimer
import android.transition.*
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {


            val myTransitionSet = TransitionSet()
            val myTransition = Slide(Gravity.END)
            myTransition.duration = 2000L
            myTransitionSet.addTransition(myTransition)
            val cb = ChangeBounds()
            cb.duration = 5000L
            myTransitionSet.addTransition(cb)
            TransitionManager.beginDelayedTransition(binding.root,myTransitionSet)
            flag = !flag
            if (flag) {
                binding.text.visibility = View.VISIBLE
            } else {
                binding.text.visibility = View.GONE
            }
        }

    }

    fun old(){
        val timer = object : CountDownTimer(2000L,200L){
            override fun onTick(millisUntilFinished: Long) {
                binding.text.alpha -= 0.1f
                binding.text.scaleY -=0.1f
            }
            override fun onFinish() {
                binding.text.alpha = 0f
                binding.text.scaleY = 0f
                binding.text.visibility = View.GONE
            }
        }
        timer.start()
    }
}
