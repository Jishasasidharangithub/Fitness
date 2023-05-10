package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.IngredientItemBinding

class IngredientItemAdapter : RecyclerView.Adapter<IngredientItemAdapter.IngredientItemViewHolder>() {

    private val ingredientItem = mutableListOf<IngredientItem>()

    inner class IngredientItemViewHolder(val binding: IngredientItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientItemAdapter.IngredientItemViewHolder {
        return IngredientItemViewHolder(
            IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<IngredientItem>) {
        ingredientItem.clear()
        ingredientItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: IngredientItemAdapter.IngredientItemViewHolder,
        position: Int
    ) {
        with(ingredientItem[position]){
            holder.binding.ivSoda.setImageResource(image)
            holder.binding.tvTitle.text=title
            holder.binding.tvQuatity.text=description

        }
    }

    override fun getItemCount(): Int {
        return ingredientItem.size
    }
}