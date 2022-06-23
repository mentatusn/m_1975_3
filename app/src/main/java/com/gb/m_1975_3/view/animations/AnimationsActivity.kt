package com.gb.m_1975_3.view.animations

import android.os.Bundle
import android.os.CountDownTimer
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
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

            val myAutoTransition = TransitionSet()
            myAutoTransition.ordering = TransitionSet.ORDERING_SEQUENTIAL // по очереди
            myAutoTransition.addTransition(Fade(Fade.OUT))
            myAutoTransition.addTransition(ChangeBounds())
            myAutoTransition.addTransition(Fade(Fade.IN))
            myAutoTransition.duration = 2000L
            TransitionManager.beginDelayedTransition(binding.root,myAutoTransition)
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
