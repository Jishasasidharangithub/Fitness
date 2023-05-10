package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.FoodTimeBinding
import com.example.fitness.databinding.NutritionItemBinding

class NutritionItemAdapter : RecyclerView.Adapter<NutritionItemAdapter.NutritionItemViewHolder>()  {

    private val nutritionItem = mutableListOf<NutritionItem>()

    inner class NutritionItemViewHolder(val binding: NutritionItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionItemViewHolder {

        return NutritionItemViewHolder(
            NutritionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return nutritionItem.size
    }
    fun updateList(list: List<NutritionItem>) {
        nutritionItem.clear()
        nutritionItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NutritionItemViewHolder, position: Int) {
        with(nutritionItem[position]){
            holder.binding.ivFire.setImageResource(image)
            holder.binding.tvCalory.text=title

        }
    }

}