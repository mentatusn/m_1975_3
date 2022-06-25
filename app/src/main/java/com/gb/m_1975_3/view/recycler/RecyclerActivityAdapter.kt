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

class RecyclerActivityAdapter(val callback: SomeActionAdapter) :
    RecyclerView.Adapter<RecyclerActivityAdapter.BaseViewHolder>() {

    // FIXME не имеем права использовать Mutable внутри адаптера
    private var dataList: MutableList<Data> = mutableListOf()
    fun setData(newData: MutableList<Data>) {
        this.dataList = newData
        notifyDataSetChanged()
    }

    private fun generateItem() = Data("Mars(G)", "", type = TYPE_MARS)

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return when (viewType) {
            TYPE_EARTH -> {
                val binding =
                    com.gb.m_1975_3.databinding.ActivityRecyclerItemEarthBinding.inflate(
                        LayoutInflater.from(parent.context)
                    )
                EarthViewHolder(binding)
            }
            TYPE_MARS -> {
                val binding =
                    com.gb.m_1975_3.databinding.ActivityRecyclerItemMarsBinding.inflate(
                        LayoutInflater.from(parent.context)
                    )
                MarsViewHolder(binding.root)
            }
            TYPE_HEADER -> {
                val binding =
                    com.gb.m_1975_3.databinding.ActivityRecyclerItemHeaderBinding.inflate(
                        LayoutInflater.from(parent.context)
                    )
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
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
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

    inner class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(data: Data) {
            val binding = ActivityRecyclerItemMarsBinding.bind(itemView)
            binding.name.text = data.name
            binding.addItemImageView.setOnClickListener {
                // FIXME НУЖНО ПРОБРОСИТЬ СОБЫТИЕ ЧЕРЕЗ ЦЕПОЧКУ ADAPTER->VIEW->VIEW_MODEL->REPOSITORY и обратно
                //FIXME callback.
                dataList.add(adapterPosition,generateItem())
                notifyItemInserted(adapterPosition)
            }
            binding.removeItemImageView.setOnClickListener {
                // FIXME НУЖНО ПРОБРОСИТЬ СОБЫТИЕ ЧЕРЕЗ ЦЕПОЧКУ ADAPTER->VIEW->VIEW_MODEL->REPOSITORY и обратно
                // FIXME callback.
                dataList.removeAt(layoutPosition)
                notifyItemRemoved(layoutPosition)
            }
        }
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Data)
    }

}