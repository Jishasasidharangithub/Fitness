package com.example.fitness.execersise_detail

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentJampingJakeBinding


class JampingJakeFragment : Fragment() {

    private var binding: FragmentJampingJakeBinding? = null
    private val stepItemAdapter: StepItemAdapter by lazy { StepItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJampingJakeBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )

        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setData()

        val description =
            "A jumping jack, also known as a star jump and called a side-straddle hop in the US military, is a physical jumping exercise performed by jumping to a position with the legs spread wide .A jumping jack, also known as a star jump and called a side-straddle hop in the US military, is a physical jumping exercise performed by jumping to a position with the legs spread wide A jumping jack, also known as a star jump and called a side-straddle hop in the US military, is a physical jumping exercise performed by jumping to a position with the legs spread wide "

        binding?.tvDescription1?.text = description.substring(0, 50) + "..."

        binding?.tvReadMore?.setOnClickListener {
            binding?.tvDescription1?.text = description
            binding?.tvReadMore?.visibility = View.GONE
        }

        val mediaController = MediaController(requireContext())

        mediaController.setAnchorView(binding?.videoView)

        val onlineUri: Uri =
            Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")

        binding?.videoView?.setMediaController(mediaController)
        binding?.videoView?.setVideoURI(onlineUri)
        binding?.videoView?.requestFocus()
        binding?.videoView?.start()

        val value = Array(10) { i ->
            "450 Calories Burn ${i+1} times"
         }
/*

        binding?.npCalories?.minValue = 0
        binding?.npCalories?.maxValue = 10


        // Set number picker listener


        binding?.npCalories?.setFormatter { index ->
            Log.d("text","${value.size}  $index")
            binding?.tvCaloriesBurn?.text = "Constant Value"
            binding?.ivFire?.setImageResource(R.drawable.ic_fire)
            value[index-1].toString()
        }
*/
        binding?.npCalories?.apply {
            minValue = 0
            maxValue = value.size - 1
            wrapSelectorWheel = false
            displayedValues = value
        }
        binding?.btnSave?.setOnClickListener {
            Toast.makeText(
                requireContext(),
                binding?.npCalories?.value.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun init() {

        binding?.rvHowToDo?.apply {
            adapter = stepItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setData() {
        val stepItem = listOf(
            StepItem(
                "01",
                "Spread Your Arms",
                "To make the gestures feel more relaxed, stretch your arms as you start this movement. No bending of hands."
            ), StepItem(
                "02",
                "Rest at The Toe",
                "The basis of this movement is jumping. Now, what needs to be considered is that you have to use the tips of your feet"
            ), StepItem(
                "03",
                "Adjust Foot Movement",
                "Jumping Jack is not just an ordinary jump. But, you also have to pay close attention to leg movements."
            ), StepItem(
                "04",
                "Clapping Both Hands",
                "This cannot be taken lightly. You see, without realizing it, the clapping of your hands helps you to keep your rhythm while doing the Jumping Jack"
            )
        )
        stepItemAdapter.updateList(stepItem)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.videoView?.stopPlayback()
        binding = null
    }
}