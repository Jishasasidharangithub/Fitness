package com.example.fitness.workouttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentWorkOutTrackerScrollViewBinding
import com.example.fitness.utils.logThis

class WorkOutTrackerScrollViewFragment : Fragment(), WorkOutAdapter.WorkOutAdapterListener {

    private var binding: FragmentWorkOutTrackerScrollViewBinding? = null
    private val workOutAdapter: WorkOutAdapter by lazy {
        WorkOutAdapter(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkOutTrackerScrollViewBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    private var workoutItem = mutableListOf<WorkoutItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        init()
        setData()
        handleEvents()
    }

    private fun handleEvents() {
        binding?.simpleSwitch1?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch1:ON" else "Switch1:OFF"
            Toast.makeText(
                requireContext(), message,
                Toast.LENGTH_SHORT
            ).show()
        }

        binding?.simpleSwitch2?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch1:ON" else "Switch1:OFF"
            Toast.makeText(
                requireContext(), message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun init() {

        binding?.rvWorkOutContent?.apply {
            adapter = workOutAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    fun setData() {
        workoutItem.addAll(
            listOf(
                WorkoutItem(
                    "Full body Workout",
                    "11 Exercises | 32mins",
                    "View more",
                    R.drawable.fullbody
                ), WorkoutItem(
                    "Lower body Workout",
                    "12 Exercises | 40mins",
                    "View more",
                    R.drawable.lowerbody
                ), WorkoutItem(
                    "ABS Workout",
                    "14 Exercises | 20mins",
                    "View more",
                    R.drawable.absbody
                )
            )
        )
        workOutAdapter.updateList(workoutItem)
    }

    override fun viewMoreClick(workoutItem: WorkoutItem, pos: Int) {
        //logThis(workoutItem.title)
        findNavController().navigate(R.id.fullbodyFragment)
    }
}