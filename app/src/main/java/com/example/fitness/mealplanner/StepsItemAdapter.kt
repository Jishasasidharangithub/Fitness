package com.example.fitness.mealplanner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ExecerisesStepsBinding



class StepsItemAdapter : RecyclerView.Adapter<StepsItemAdapter.StepsItemViewHolder>() {

    private val stepsItem = mutableListOf<StepsItem>()

    inner class StepsItemViewHolder(val binding: ExecerisesStepsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StepsItemAdapter.StepsItemViewHolder {
        return StepsItemViewHolder(
            ExecerisesStepsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<StepsItem>) {
        stepsItem.clear()
        stepsItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return stepsItem.size
    }

    override fun onBindViewHolder(holder: StepsItemAdapter.StepsItemViewHolder, position: Int) {
        with(stepsItem[position]){
            holder.binding.tvSteps.text=steps
            holder.binding.tvStepTitle.text=title
            holder.binding.tvStepDescription.text=description
        }
    }
}