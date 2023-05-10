package com.example.fitness.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.CalnderItemBinding

data class CalnderAdapter(val workoutScheduleFragment: WorkoutScheduleFragment) : RecyclerView.Adapter<CalnderAdapter.CalnderItemViewHolder>(){

    private val calnderItem = mutableListOf<String>()
    inner class CalnderItemViewHolder(val binding: CalnderItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalnderItemViewHolder {
        return CalnderItemViewHolder(
            CalnderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return calnderItem.size
    }

    fun updateList(list: List<String>){
        calnderItem.clear()
        calnderItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CalnderItemViewHolder, position: Int) {
        with(calnderItem[position]) {
            holder.binding.tvWeekDay.text = this
            holder.binding.tvDate.text = (position + 1).toString()
        }
    }

}
