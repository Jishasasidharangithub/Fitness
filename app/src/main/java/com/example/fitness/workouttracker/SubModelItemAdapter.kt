package com.example.fitness.workouttracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemRcvSubBinding

class SubModelItemAdapter(private val listener: SubModelItemAdapter.SubModelItemListener) :
    RecyclerView.Adapter<SubModelItemAdapter.SubModelViewHolder>() {

    private val submodelItem = mutableListOf<SubModelItemRecycler>()
    inner class SubModelViewHolder(val binding:ItemRcvSubBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubModelItemAdapter. SubModelViewHolder {
        return SubModelViewHolder(
            ItemRcvSubBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return submodelItem.size
    }

    fun updateList(list: List<SubModelItemRecycler>){
        submodelItem.clear()
        submodelItem.addAll(list)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: SubModelViewHolder, position: Int) {
        with(submodelItem[position]) {
            holder.binding.ivSet1Image1.setImageResource(image)
            holder.binding.tvWarmUp.text = title
            holder.binding.tvWarmUpTime.text = duration
            holder.binding.ivIconNext.setOnClickListener {
                listener.viewMoreClick(this)
            }
         }
    }
    interface SubModelItemListener {

        fun viewMoreClick(submodelItem:SubModelItemRecycler)
        
    }

}