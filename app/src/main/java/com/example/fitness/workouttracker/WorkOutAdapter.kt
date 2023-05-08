package com.example.fitness.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.WorkoutItemBinding

class WorkOutAdapter(private val listener: WorkOutAdapterListener) :
    RecyclerView.Adapter<WorkOutAdapter.WorkOutViewHolder>() {

    private val workoutItem = mutableListOf<WorkoutItem>()

    inner class WorkOutViewHolder(val binding: WorkoutItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkOutAdapter.WorkOutViewHolder {
        return WorkOutViewHolder(
            WorkoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    fun updateList(list: List<WorkoutItem>) {
        workoutItem.clear()
        workoutItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return workoutItem.size
    }

    override fun onBindViewHolder(holder: WorkOutViewHolder, position: Int) {
        with(workoutItem[position]) {
            holder.binding.tvFullBodyWorkOut1.text = title
            holder.binding.tvExercisesTime.text = description
            holder.binding.btnViewMore.text = button
            holder.binding.ivFullBody.setImageResource(image)
            holder.binding.btnViewMore.setOnClickListener {
                listener.viewMoreClick(this, position)
            }
        }
    }

    interface WorkOutAdapterListener {
        fun viewMoreClick(workoutItem: WorkoutItem, pos: Int)
    }
}