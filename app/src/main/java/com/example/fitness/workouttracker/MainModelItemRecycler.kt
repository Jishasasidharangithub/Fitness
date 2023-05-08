package com.example.fitness.workouttracker

import com.example.fitness.workouttracker.SubModelItemRecycler

data class MainModelItemRecycler(
    val title:String,
    val list:List<SubModelItemRecycler>
)
