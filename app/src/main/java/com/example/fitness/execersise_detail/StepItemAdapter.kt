package com.example.fitness.execersise_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ExecerisesStepsBinding

class StepItemAdapter : RecyclerView.Adapter<StepItemAdapter.StepItemViewHolder>() {

    private val stepItem = mutableListOf<StepItem>()

    inner class StepItemViewHolder(val binding: ExecerisesStepsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepItemViewHolder {
        return StepItemViewHolder(
            ExecerisesStepsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<StepItem>) {
        stepItem.clear()
        stepItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return stepItem.size
    }

    override fun onBindViewHolder(holder: StepItemViewHolder, position: Int) {
        with(stepItem[position]){
            holder.binding.tvSteps.text=steps
            holder.binding.tvStepTitle.text=title
            holder.binding.tvStepDescription.text=description
        }
    }
}

