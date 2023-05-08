package com.example.fitness.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentNotificationBinding
import com.example.fitness.databinding.FragmentRegisterBinding

class NotificationFragment : Fragment() {

    private var binding: FragmentNotificationBinding? = null
    private val notificationAdapter:NotificationAdapter by lazy { NotificationAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private var notificationItem = mutableListOf<NotificationItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setData()

    }

    fun init() {
        binding?.rvFoodContent?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notificationAdapter
        }
    }

    fun setData() {
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item1, "Hey, it’s time for lunch","About 1 minutes ago",R.drawable.ic_three_dot)))
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item2, "Don’t miss your lowerbody workout","About 3 hours ago",R.drawable.ic_three_dot)))
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item3, "Hey, let’s add some meals for your b..","About 3 hours ago",R.drawable.ic_three_dot)))
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item4, "Congratulations, You have finished A..","29 May",R.drawable.ic_three_dot)))
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item5, "Hey, it’s time for lunch","8 April",R.drawable.ic_three_dot)))
        notificationItem.addAll(listOf(NotificationItem(R.drawable.ic_notification_item2, "Ups, You have missed your Lowerbo...","3 April",R.drawable.ic_three_dot)))
        notificationAdapter.updateList(notificationItem)
    }

}