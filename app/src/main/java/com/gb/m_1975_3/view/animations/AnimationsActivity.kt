package com.gb.m_1975_3.view.animations


import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat.animate
import com.gb.m_1975_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBinding
    private var flag = false
    private var duration = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fab.setOnClickListener {

            flag = !flag
            if (flag) {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, 315f).setDuration(duration)
                    .start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -250f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -130f)
                    .setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionOneContainer.isClickable = true
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(1f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            binding.optionTwoContainer.isClickable = true
                        }
                    })
                binding.transparentBackground.animate()
                    .alpha(0.5f).duration = duration

            } else {
                ObjectAnimator.ofFloat(binding.fab, View.ROTATION, 0f).setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, 0f)
                    .setDuration(duration).start()

                binding.optionOneContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationStart(animation: Animator?) {
                            super.onAnimationStart(animation)
                            binding.optionOneContainer.isClickable = false
                        }
                    })
                binding.optionTwoContainer.animate()
                    .alpha(0f)
                    .setDuration(duration)
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationStart(animation: Animator?) {
                            super.onAnimationStart(animation)
                            binding.optionTwoContainer.isClickable = false
                        }
                    })

                binding.transparentBackground.animate()
                    .alpha(0f).duration = duration

            }
        }
    }


}
