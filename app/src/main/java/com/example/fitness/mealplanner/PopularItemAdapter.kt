package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.PopularItemBinding

class PopularItemAdapter : RecyclerView.Adapter<PopularItemAdapter.PopularItemViewHolder>() {

    private val popularItem = mutableListOf<PopularItem>()

    inner class PopularItemViewHolder(val binding: PopularItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularItemAdapter.PopularItemViewHolder {
        return PopularItemViewHolder(
            PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<PopularItem>) {
        popularItem.clear()
        popularItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PopularItemAdapter.PopularItemViewHolder, position: Int) {

            with(popularItem[position]) {
                holder.binding.ivPopular.setImageResource(image)
                holder.binding.tvPopular.text = title
                holder.binding.tvPopularCalory.text = description
            }

    }

    override fun getItemCount(): Int {
        return popularItem.size
    }
}