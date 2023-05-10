package com.example.fitness.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemMainRcvBinding

class MainModelItemAdapter (private val listener: SubModelItemAdapter.SubModelItemListener) : RecyclerView.Adapter<MainModelItemAdapter.MainItemViewHolder>() {

    private val mainmodelItem = mutableListOf<MainModelItemRecycler>()

    inner class MainItemViewHolder(val binding: ItemMainRcvBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        return MainItemViewHolder(
            ItemMainRcvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mainmodelItem.size
    }
    fun updateList(list: List<MainModelItemRecycler>){
        mainmodelItem.clear()
        mainmodelItem.addAll(list)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        with(mainmodelItem[position]) {
            holder.binding.tvSet1.text = title
            val subAdapter = SubModelItemAdapter(listener)
            holder.binding.rvSet1.apply {
                adapter = subAdapter
                layoutManager = LinearLayoutManager(holder.itemView.context)
            }
            subAdapter.updateList(list)
        }
    }

}