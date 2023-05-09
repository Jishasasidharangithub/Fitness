package com.example.fitness.mealplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentBreakfastBinding
import com.example.fitness.databinding.FragmentMealPlannerBinding


class BreakfastFragment : Fragment() {

    private var binding: FragmentBreakfastBinding? = null
    private val categoryItemAdapter: CategoryItemAdapter by lazy { CategoryItemAdapter() }
    private val dietItemAdapter: DietItemAdapter by lazy { DietItemAdapter() }
    private val popularItemAdapter: PopularItemAdapter by lazy { PopularItemAdapter() }


    private var categoryItem = mutableListOf<CategoryItem>()
    private val dietItem = mutableListOf<DietItem>()
    private val popularItem = mutableListOf<PopularItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBreakfastBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setData()
    }

    private fun initViews() {
        binding?.rvCategory?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryItemAdapter
        }

        binding?.rvDiet?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = dietItemAdapter

        }
        binding?.rvPopular?.apply {
            layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = popularItemAdapter

        }

    }

    private fun setData() {
        categoryItem.addAll(
            listOf(
                CategoryItem(R.drawable.salad, "Salad"),
                CategoryItem(R.drawable.salad, "Cake"),
                CategoryItem(R.drawable.salad, "Pie"),
                CategoryItem(R.drawable.salad, "Smoothing"),

                )
        )
        categoryItemAdapter.updateList(categoryItem)

        dietItem.addAll(
            listOf(
                DietItem(R.drawable.breakfast, "Honey Pancake", "Easy | 30mins | 180kCal", R.drawable.view),
                DietItem(R.drawable.lunch, "Canai Bread", "Easy | 20mins | 230kCal", R.drawable.view)
                )
        )
        dietItemAdapter.updateList(dietItem)

        popularItem.addAll(
            listOf(
                PopularItem(R.drawable.breakfast,"Blueberry Pancake","Medium | 30mins | 230kCal"),
                PopularItem(R.drawable.ic_salmon_nigiri,"Salmon Nigiri","Medium | 20mins | 120kCal")
            )

        )
        popularItemAdapter.updateList(popularItem)
    }


}

