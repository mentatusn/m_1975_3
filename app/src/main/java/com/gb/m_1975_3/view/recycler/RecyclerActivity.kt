package com.gb.m_1975_3.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    val adapter = RecyclerActivityAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRecyclerBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter =adapter

        val data = arrayListOf(
            Data("Earth", type = TYPE_EARTH),
            Data("Earth", type = TYPE_EARTH),
            Data("Mars", "", type = TYPE_MARS),
            Data("Earth", type = TYPE_EARTH),
            Data("Earth", type = TYPE_EARTH),
            Data("Earth", type = TYPE_EARTH),
            Data("Mars", null,type = TYPE_MARS)
        )
        data.add(0,Data("Заголовок", type = TYPE_HEADER))

        adapter.setData(data)
    }
}
