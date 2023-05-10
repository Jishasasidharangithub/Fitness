package com.example.fitness.workouttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentWorkoutScheduleBinding
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class WorkoutScheduleFragment : Fragment() {
    private var mCal = Calendar.getInstance()
    private var binding: FragmentWorkoutScheduleBinding? = null
    private val dayNames by lazy { DateFormatSymbols().weekdays }

    private val calnderAdapter by lazy { CalnderAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutScheduleBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    private var calnderItem = mutableListOf<CalnderItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setMonthData(mCal.timeInMillis)
        handleEvents()

        binding?.ivAddSchedule?.setOnClickListener {
            findNavController().navigate(R.id.addscheduleFragment)
        }
    }

    private fun handleEvents() {
        binding?.ivStroke1?.setOnClickListener {
            goToPreviousMonth()
        }
        binding?.ivStroke2?.setOnClickListener {
            goToNextMonth()
        }
    }

    private fun goToNextMonth() {
        val nextMonthMillis = mCal.apply { add(Calendar.MONTH, 1) }.timeInMillis
        setMonthData(nextMonthMillis)
    }

    private fun goToPreviousMonth() {
        val prevMonthMillis = mCal.apply { add(Calendar.MONTH, -1) }.timeInMillis
        setMonthData(prevMonthMillis)
    }

    private fun setMonthData(time: Long) {
        val monthYear = SimpleDateFormat("MMM, yyyy", Locale.ENGLISH).format(time)
        binding?.tvMonthYear?.text = monthYear

        val numberOfDays =
            mCal.getActualMaximum(Calendar.DAY_OF_MONTH) //to get total number of days in a given month

        val calList = List(numberOfDays) {
            val cal = mCal
            cal.set(Calendar.DAY_OF_MONTH, it + 1)
            val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
            dayNames[dayOfWeek]
        }
        calnderAdapter.updateList(calList)
    }

    private fun init() {

        binding?.rvRcalnder?.apply {
            adapter = calnderAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        }
    }

}