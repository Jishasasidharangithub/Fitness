package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.FoodTimeBinding


class MealPlannerAdapter : RecyclerView.Adapter<MealPlannerAdapter.FoodTimeViewHolder>() {

    private val foodTime = mutableListOf<FoodTime>()

    inner class FoodTimeViewHolder(val binding: FoodTimeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealPlannerAdapter.FoodTimeViewHolder {
        return FoodTimeViewHolder(
            FoodTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<FoodTime>) {
        foodTime.clear()
        foodTime.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MealPlannerAdapter.FoodTimeViewHolder, position: Int) {
        with(foodTime[position]){
            holder.binding.ivBreakFast.setImageResource(image1)
            holder.binding.tvBreakfast.text=title
            holder.binding.tvBreakfastFoods.text=description
            holder.binding.ivSelect1.setImageResource(image2)
        }
    }

    override fun getItemCount(): Int {
        return foodTime.size
    }
}