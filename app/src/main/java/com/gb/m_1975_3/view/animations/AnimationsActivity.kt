package com.gb.m_1975_3.view.animations


import android.os.Bundle
import androidx.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityAnimationsBonusStartBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBonusStartBinding
    private var flag = false
    private var duration = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val constraintSetStart = ConstraintSet()
        val constraintSetEnd= ConstraintSet()
        constraintSetStart.clone(binding.root)
        constraintSetEnd.load(this, R.layout.activity_animations_bonus_end)
        binding.backgroundImage.setOnClickListener {
            flag = !flag
            val changeBounds = ChangeBounds()
            changeBounds.duration =1000L
            changeBounds.interpolator = AnticipateOvershootInterpolator(5.0f)
            TransitionManager.beginDelayedTransition(binding.root,changeBounds)
            if(flag){
                constraintSetEnd.applyTo(binding.root)
            }else{
                constraintSetStart.applyTo(binding.root)
            }
        }

    }


}
