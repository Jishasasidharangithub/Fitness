package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.CategoryItemBinding


class CategoryItemAdapter : RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder>()  {

    private val categoryItem = mutableListOf<CategoryItem>()

    inner class CategoryItemViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryItemAdapter.CategoryItemViewHolder {
        return CategoryItemViewHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<CategoryItem>) {
        categoryItem.clear()
        categoryItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: CategoryItemAdapter.CategoryItemViewHolder,
        position: Int
    ) {
        with(categoryItem[position]){
            holder.binding.ivSalad.setImageResource(image)
            holder.binding.tvSalad.text=title
        }
    }

    override fun getItemCount(): Int {
        return categoryItem.size
    }
}