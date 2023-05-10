package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemSubMealRcvBinding
import com.example.fitness.workouttracker.SubModelItemRecycler

class SubMealItemAdapter () : RecyclerView.Adapter<SubMealItemAdapter.SubMealViewHolder>()  {

    private val submealItem = mutableListOf<SubMealItemRecycler>()
    inner class SubMealViewHolder(val binding: ItemSubMealRcvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubMealItemAdapter.SubMealViewHolder {
        return SubMealViewHolder(
            ItemSubMealRcvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<SubMealItemRecycler>){
        submealItem.clear()
        submealItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SubMealItemAdapter.SubMealViewHolder, position: Int) {
        with(submealItem[position]) {
            holder.binding.ivSet1Image1.setImageResource(image)
            holder.binding.tvWarmUp.text = title
            holder.binding.tvWarmUpTime.text = description


        }
    }

    override fun getItemCount(): Int {
        return submealItem.size
    }
}