package com.gb.m_1975_3.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.m_1975_3.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    private val adapter = RecyclerActivityAdapter { position, data -> /*TODO WH */ }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRecyclerBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        val lat = 12
        val lon = 22
        val z = 22

        val location = Pair(lat, lon)
        val location3D = Triple(lat, lon, z)
        val locationAnotherOne = lat to lon
        val location3DAnother = lat to lon to z

        location.second
        location.first
        location3D.third

        val data = arrayListOf(
            Pair(Data("Earth", type = TYPE_EARTH), false),
            Pair(Data("Earth", type = TYPE_EARTH), false),
            Pair(Data("Mars", "", type = TYPE_MARS), false),
            Pair(Data("Earth", type = TYPE_EARTH), false),
            Pair(Data("Earth", type = TYPE_EARTH), false),
            Pair(Data("Earth", type = TYPE_EARTH), false),
            Pair(Data("Mars", null, type = TYPE_MARS), false)
        )
        data.add(0, Pair(Data("Заголовок", type = TYPE_HEADER), false))

        adapter.setData(data)
    }
}
