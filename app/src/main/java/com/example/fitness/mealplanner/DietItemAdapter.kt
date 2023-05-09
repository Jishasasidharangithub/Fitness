package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.DietItemBinding

class DietItemAdapter : RecyclerView.Adapter<DietItemAdapter.DietItemViewHolder>()  {

    private val dietItem = mutableListOf<DietItem>()

    inner class DietItemViewHolder(val binding: DietItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DietItemAdapter.DietItemViewHolder {
        return DietItemViewHolder(
            DietItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<DietItem>) {
        dietItem.clear()
        dietItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DietItemAdapter.DietItemViewHolder, position: Int) {

        with(dietItem[position]){
            holder.binding.ivPancake.setImageResource(image)
            holder.binding.tvPancake.text=title
            holder.binding.tvCake.text=description
            holder.binding.ivView.setImageResource(image1)
        }
    }

    override fun getItemCount(): Int {
        return dietItem.size
    }
}