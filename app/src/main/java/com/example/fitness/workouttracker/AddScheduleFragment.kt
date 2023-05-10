package com.example.fitness.workouttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitness.R
import com.example.fitness.databinding.FragmentAddScheduleBinding
import com.example.fitness.databinding.FragmentJampingJakeBinding


class AddScheduleFragment : Fragment() {

    private var binding: FragmentAddScheduleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddScheduleBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = Array(12) { i -> "${i+1} "}
        binding?.npHour?.apply {
            minValue = 0
            maxValue = value.size - 1
            wrapSelectorWheel = false
            displayedValues = value
        }

        val value1 = Array(60) { i -> "${i+1} "}
        binding?.npMinute?.apply {
            minValue = 0
            maxValue = value1.size - 1
            wrapSelectorWheel = false
            displayedValues = value1
        }
        val value2 = arrayOf("AM","PM")
        binding?.npTime?.apply {
            minValue = 0
            maxValue = value2.size - 1
            wrapSelectorWheel = false
            displayedValues = value2
        }
    }

}