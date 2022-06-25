package com.gb.m_1975_3.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.m_1975_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.m_1975_3.databinding.ActivityRecyclerItemMarsBinding


const val TYPE_EARTH = 0
const val TYPE_MARS = 1
const val TYPE_HEADER = 2

class RecyclerActivityAdapter(val callback: SomeActionAdapter) :
    RecyclerView.Adapter<RecyclerActivityAdapter.BaseViewHolder>(),ItemTouchHelperAdapter {

    // FIXME не имеем права использовать Mutable внутри адаптера
    private var dataList: MutableList<Pair<Data,Boolean>> = mutableListOf()
    fun setData(newData: MutableList<Pair<Data,Boolean>>) {
        this.dataList = newData
        notifyDataSetChanged()
    }

    private fun generateItem() = Pair(Data("Mars(G)", "", type = TYPE_MARS),false)

    override fun getItemViewType(position: Int): Int {
        return dataList[position].first.type
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
        override fun bind(data: Pair<Data,Boolean>) {
            binding.name.text = data.first.name
        }
    }

    class HeaderViewHolder(val binding: ActivityRecyclerItemHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Data,Boolean>) {
            binding.name.text = data.first.name
        }
    }

    inner class MarsViewHolder(view: View) : BaseViewHolder(view),ItemTouchHelperViewHolder {
        override fun bind(data: Pair<Data,Boolean>) {
            val binding = ActivityRecyclerItemMarsBinding.bind(itemView)
            binding.name.text = data.first.name
            binding.marsDescriptionTextView.visibility = if(data.second) View.VISIBLE else View.GONE
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

            binding.moveItemUp.setOnClickListener {
                // TODO HW убрать ошибку java.lang.IndexOutOfBoundsException:
                dataList.removeAt(layoutPosition).apply {
                    dataList.add(layoutPosition -1, this)
                }

                notifyItemMoved(layoutPosition,layoutPosition-1)
            }
            binding.moveItemDown.setOnClickListener {
                // TODO HW убрать ошибку java.lang.IndexOutOfBoundsException:
                dataList.removeAt(layoutPosition).apply {
                    dataList.add(layoutPosition +1, this)
                }
                notifyItemMoved(layoutPosition,layoutPosition+1)
            }

            binding.name.setOnClickListener {
                dataList[layoutPosition] = dataList[layoutPosition].let {
                    it.first to !it.second
                }
                //binding.marsDescriptionTextView.visibility = if(dataList[layoutPosition].second) View.VISIBLE else View.GONE
                notifyItemChanged(layoutPosition)
            }
        }

        override fun onItemSelected() {
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.colorAccent))
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Pair<Data,Boolean>)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) { // TODO HW нельзя двигать выше HEADER
        dataList.removeAt(fromPosition).apply {
            dataList.add(toPosition , this)
        }
        notifyItemMoved(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

}