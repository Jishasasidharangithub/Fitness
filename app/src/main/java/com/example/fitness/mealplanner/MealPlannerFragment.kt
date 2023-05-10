package com.example.fitness.mealplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentJampingJakeBinding
import com.example.fitness.databinding.FragmentMealPlannerBinding
import com.example.fitness.execersise_detail.StepItemAdapter
import com.example.fitness.workouttracker.ExecricesItem
import com.example.fitness.workouttracker.SubModelItemRecycler
import com.example.fitness.workouttracker.WorkoutItem

class MealPlannerFragment : Fragment(), MealPlannerAdapter.MealPlannerAdapterListener {

    private var binding: FragmentMealPlannerBinding? = null
    private val mealPlannerAdapter: MealPlannerAdapter by lazy {
        MealPlannerAdapter(this)
    }

    private var foodTime = mutableListOf<FoodTime>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealPlannerBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        binding?.btnCheck?.setOnClickListener {
            findNavController().navigate(R.id.mealscheduleFragment)
        }
    }

    private fun initViews() {
        binding?.rvFoodTime?.apply {
           layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = mealPlannerAdapter
        }
        setData()
    }

    private fun setData() {
        foodTime.addAll(
            listOf(
                FoodTime(R.drawable.breakfast, "Breakfast","120+ Foods",R.drawable.select1),
                FoodTime(R.drawable.lunch, "Lunch","130+ Foods",R.drawable.select2)
            )
        )
        mealPlannerAdapter.updateList(foodTime)
    }

    override fun viewMoreClick(foodTime: FoodTime, pos: Int) {
        //logThis(workoutItem.title)
        findNavController().navigate(R.id.breakfastFragment)
    }

}