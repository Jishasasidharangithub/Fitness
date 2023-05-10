package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemMainMealRcvBinding
import com.example.fitness.workouttracker.WorkoutItem


class MainMealItemAdapter () : RecyclerView.Adapter<MainMealItemAdapter.MainMealItemViewHolder>() {

    private val mainmealItem = mutableListOf<MainMealItemRecycler>()

    inner class MainMealItemViewHolder(val binding: ItemMainMealRcvBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainMealItemAdapter.MainMealItemViewHolder {
        return MainMealItemViewHolder(
            ItemMainMealRcvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<MainMealItemRecycler>){
        mainmealItem.clear()
        mainmealItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: MainMealItemAdapter.MainMealItemViewHolder,
        position: Int
    ) {
        with(mainmealItem[position]) {
            holder.binding.tvSet1.text = title
            val subAdapter1 = SubMealItemAdapter()
            holder.binding.rvSet1.apply {
                adapter = subAdapter1
                layoutManager = LinearLayoutManager(holder.itemView.context)
            }
            subAdapter1.updateList(list)
        }
    }

    override fun getItemCount(): Int {
        return mainmealItem.size
    }


}