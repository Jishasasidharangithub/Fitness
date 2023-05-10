package com.example.fitness.mealplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentMealScheduleBinding
import com.example.fitness.workouttracker.SubModelItemRecycler
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class MealScheduleFragment() : Fragment() {

    private var mCal = Calendar.getInstance()
    private var binding: FragmentMealScheduleBinding? = null
    private val dayNames by lazy { DateFormatSymbols().weekdays }

    private val mealcalnderAdapter by lazy { MealCalenderAdapter(this) }
    private val mainMealItemAdapter: MainMealItemAdapter by lazy { MainMealItemAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealScheduleBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    private var mealcalnderItem = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleEvents()
        init()
        setMonthData(mCal.timeInMillis)
        mealItem()
        mealData()
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
        mealcalnderAdapter.updateList(calList)
    }

    private fun init() {

        binding?.rvMealCalnder?.apply {
            adapter = mealcalnderAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
        }
    }

    fun mealItem() {
        binding?.rvSet?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainMealItemAdapter
        }
    }

    fun mealData() {
        val subList = listOf(
            SubMealItemRecycler(
                R.drawable.breakfast,
                "Honey Pancake",
                "05:00"
            ), SubMealItemRecycler(
                R.drawable.glass_of_milk,
                "Coffee",
                "06:00"
            )
        )

        val subList1 = listOf(
            SubMealItemRecycler(
                R.drawable.lunch,
                "Chicken Steak",
                "1.00"
            ), SubMealItemRecycler(
                R.drawable.glass_of_milk,
                "Milk",
                "1.20"
            )
        )

        val subList2 = listOf(
            SubMealItemRecycler(
                R.drawable.lunch,
                "Chicken Steak",
                "1.00"
            ), SubMealItemRecycler(
                R.drawable.glass_of_milk,
                "Milk",
                "1.20"
            )
        )

        val subList3 = listOf(
            SubMealItemRecycler(
                R.drawable.lunch,
                "Chicken Steak",
                "1.00"
            ), SubMealItemRecycler(
                R.drawable.glass_of_milk,
                "Milk",
                "1.20"
            )
        )

        val mainList = listOf(
            MainMealItemRecycler("Breakfast", "2 meals | 230 calories", subList),
            MainMealItemRecycler("Lunch", "2 meals | 230 calories", subList1),
            MainMealItemRecycler("Snacks", "2 meals | 230 calories", subList2),
            MainMealItemRecycler("Dinner", "2 meals | 230 calories", subList3)
        )

        mainMealItemAdapter.updateList(mainList)
    }

}