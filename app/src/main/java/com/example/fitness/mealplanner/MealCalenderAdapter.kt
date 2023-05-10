package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.CalnderItemBinding

data class MealCalenderAdapter(val mealScheduleFragment: MealScheduleFragment) : RecyclerView.Adapter<MealCalenderAdapter.MealItemViewHolder>(){

    private val calnderItem = mutableListOf<String>()
    inner class MealItemViewHolder(val binding: CalnderItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealItemViewHolder {
        return MealItemViewHolder(
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

    override fun onBindViewHolder(holder: MealItemViewHolder, position: Int) {
        with(calnderItem[position]) {
            holder.binding.tvWeekDay.text = this
            holder.binding.tvDate.text = (position + 1).toString()
        }
    }

}
