package com.example.fitness.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.NotificationItemBinding

class NotificationAdapter () : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    private val notificationItem = mutableListOf<NotificationItem>()
    inner class NotificationViewHolder(val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationAdapter.NotificationViewHolder {
        return NotificationViewHolder(
            NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: NotificationAdapter.NotificationViewHolder,
        position: Int
    ) {
        with(notificationItem[position]){
            holder.binding.ivNotificationItem1.setImageResource(image)
            holder.binding.tvNotificationItem1.text=title
            holder.binding.tvNotificationDescription.text=description
            holder.binding.ivThreeDot.setImageResource(image1)
        }
    }

    fun updateList(list: List<NotificationItem>){
        notificationItem.clear()
        notificationItem.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return notificationItem.size
    }
}