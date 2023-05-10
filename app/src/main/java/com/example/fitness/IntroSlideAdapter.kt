package com.example.fitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.SlideItemContainerBinding

class IntroSlideAdapter () : RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewHolder>() {

    private val dataItem = mutableListOf<IntroSlide>()

    inner class IntroSlideViewHolder(val binding: SlideItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataItem.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        with(dataItem[position]) {
            holder.binding.tvTitleText.text = title
            holder.binding.tvDescriptionText.text = description
            holder.binding.ivSlide1.setImageResource(icon)
        }

    }

    fun updateList(list: List<IntroSlide>) {
        dataItem.clear()
        dataItem.addAll(list)
        notifyDataSetChanged()
    }
}