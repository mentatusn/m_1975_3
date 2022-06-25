package com.gb.m_1975_3.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_1975_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.m_1975_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.m_1975_3.databinding.ActivityRecyclerItemMarsBinding


const val TYPE_EARTH = 0
const val TYPE_MARS = 1
const val TYPE_HEADER = 2

class RecyclerActivityAdapter() :
    RecyclerView.Adapter<RecyclerActivityAdapter.BaseViewHolder>() {

    private var data: List<Data> = listOf()
    fun setData(newData: List<Data>) {
        this.data = newData
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return when (viewType) {
            TYPE_EARTH -> {
                val binding =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(binding)
            }
            TYPE_MARS -> {
                val binding =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(binding.root)
            }
            TYPE_HEADER -> {
                val binding =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(binding)
            }
            else -> {
                val binding =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        //val myViewType = getItemViewType(position)
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class EarthViewHolder(val binding: ActivityRecyclerItemEarthBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.name.text = data.name
        }
    }

    class HeaderViewHolder(val binding: ActivityRecyclerItemHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.name.text = data.name
        }
    }

    class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Data) {
            val binding = ActivityRecyclerItemMarsBinding.bind(itemView)
            binding.name.text = data.name
        }
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Data)
    }

}