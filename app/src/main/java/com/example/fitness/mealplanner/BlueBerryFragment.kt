package com.example.fitness.mealplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentBlueBerryBinding
import com.example.fitness.databinding.FragmentMealPlannerBinding
import com.example.fitness.execersise_detail.StepItem


class BlueBerryFragment : Fragment() {

    private var binding: FragmentBlueBerryBinding? = null
    private val nutritionItemAdapter: NutritionItemAdapter by lazy { NutritionItemAdapter() }
    private val ingredientItemAdapter: IngredientItemAdapter by lazy { IngredientItemAdapter() }
    private val stepsItemAdapter: StepsItemAdapter by lazy { StepsItemAdapter() }

    private var nutritionItem = mutableListOf<NutritionItem>()
    private var ingredientItem = mutableListOf<IngredientItem>()
    private val stepsItem = mutableListOf<StepsItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlueBerryBinding.inflate(
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

        val description =
            "Pancakes are some people's favorite breakfast, who doesn't like pancakes? Especially with the real honey splash on top of the pancakes, of course everyone loves that! besides being .Pancakes are some people's favorite breakfast, who doesn't like pancakes? Especially with the real honey splash on top of the pancakes, of course everyone loves that! besides being .Pancakes are some people's favorite breakfast, who doesn't like pancakes? Especially with the real honey splash on top of the pancakes, of course everyone loves that! besides being "

        binding?.tvDescription1?.text = description.substring(0, 50) + "..."

        binding?.tvReadMore?.setOnClickListener {
            binding?.tvDescription1?.text = description
            binding?.tvReadMore?.visibility = View.GONE
        }

    }

    private fun initViews() {
        binding?.rvNutrition?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = nutritionItemAdapter
        }

        binding?.rvIngredients?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = ingredientItemAdapter
        }

        binding?.rv8Steps?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = stepsItemAdapter
        }

    }

    private fun setData() {
        nutritionItem.addAll(
            listOf(
                NutritionItem(R.drawable.ic_fire, "180kCal"),
                NutritionItem(R.drawable.trans_fat, "30g fats"),
                NutritionItem(R.drawable.protein_1, "20g proteins"),
                NutritionItem(R.drawable.rice, "30g rice"),

                )
        )
        nutritionItemAdapter.updateList(nutritionItem)

        ingredientItem.addAll(
            listOf(
                IngredientItem(R.drawable.flour_icon, "Wheat Flour","100gr"),
                IngredientItem(R.drawable.sugar_3, "Sugar","3 tbsp"),
                IngredientItem(R.drawable.bakingsoda_icon, "Baking Soda","2 tbsp"),
                IngredientItem(R.drawable.bakingsoda_icon, "Rice","100gr"),
                IngredientItem(R.drawable.flour_icon, "Wheat Flour","100gr"),
                IngredientItem(R.drawable.sugar_3, "Sugar","3 tbsp")


                )
        )
        ingredientItemAdapter.updateList(ingredientItem)

        stepsItem.addAll(
            listOf(
                StepsItem(
                    "01",
                    "Step1",
                    "To make the gestures feel more relaxed, stretch your arms as you start this movement. No bending of hands."
                ), StepsItem(
                    "02",
                    "Step2",
                    "The basis of this movement is jumping. Now, what needs to be considered is that you have to use the tips of your feet"
                ), StepsItem(
                    "03",
                    "Step3",
                    "Jumping Jack is not just an ordinary jump. But, you also have to pay close attention to leg movements."
                ), StepsItem(
                    "04",
                    "Step4",
                    "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
                ),  StepsItem(
                    "05",
                    "Step5",
                    "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
                ),  StepsItem(
                    "06",
                    "Step6",
                    "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
                ),  StepsItem(
                    "07",
                    "Step7",
                    "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
                ),  StepsItem(
                    "08",
                    "Step8",
                    "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
                )

            )
        )
        stepsItemAdapter.updateList(stepsItem)
    }

}