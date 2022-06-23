package com.gb.m_1975_3.view.animations

import android.graphics.Rect
import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationsBinding
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = Adapter()

    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_animations_recycler_item,
                    parent,
                    false
                ) as View
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                val transitionExplode = Explode()
                val rect = Rect()
                it.getGlobalVisibleRect(rect)
                transitionExplode.epicenterCallback = object : Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition?): Rect {
                        return rect
                    }
                }
                transitionExplode.duration= 2000L
                transitionExplode.excludeTarget(it,true)

                val transitionEpicenter = Fade()
                transitionEpicenter.addTarget(it)
                transitionEpicenter.duration = 99999999999
                val ts = TransitionSet()
                ts.addTransition(transitionExplode)
                ts.addTransition(transitionEpicenter)
                TransitionManager.beginDelayedTransition(binding.recyclerView,ts)
                binding.recyclerView.adapter = null
            }
        }

        override fun getItemCount(): Int {
            return 32
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


}
