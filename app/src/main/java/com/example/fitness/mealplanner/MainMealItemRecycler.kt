package com.example.fitness.mealplanner

import com.example.fitness.workouttracker.SubModelItemRecycler

data class MainMealItemRecycler (
val title:String,
val description:String,
val list:List<SubMealItemRecycler>
)
