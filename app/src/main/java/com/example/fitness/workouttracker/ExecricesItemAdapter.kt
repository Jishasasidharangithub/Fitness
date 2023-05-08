package com.example.fitness.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.NotificationItemBinding
import com.example.fitness.databinding.WorkoutItemListBinding

class ExecricesItemAdapter () : RecyclerView.Adapter<ExecricesItemAdapter.ExecricesItemViewHolder>() {

    private val execricesItem = mutableListOf<ExecricesItem>()
    inner class ExecricesItemViewHolder(val binding: WorkoutItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExecricesItemAdapter.ExecricesItemViewHolder {

        return ExecricesItemViewHolder(
            WorkoutItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )

    }

    override fun getItemCount(): Int {
        return execricesItem.size
    }

    fun updateList(list: List<ExecricesItem>){
        execricesItem.clear()
        execricesItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ExecricesItemViewHolder, position: Int) {
        with(execricesItem[position]) {
            holder.binding.ivBarbell.setImageResource(image)
            holder.binding.tvBarbell.text = title
        }
    }

}