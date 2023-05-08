package com.example.fitness.signup_and_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentFitnessBinding
import com.example.fitness.slider.Slider1Fragment
import com.example.fitness.slider.Slider2Fragment
import com.example.fitness.slider.Slider3Fragment


class FitnessFragment : Fragment() {

    private var binding: FragmentFitnessBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFitnessBinding.inflate(layoutInflater)
        return binding?.root
    }

    val fragmentList = arrayListOf<Fragment>(
        Slider1Fragment(),
        Slider2Fragment(),
        Slider3Fragment()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FitnessAdaptor(
            fragmentList,
            childFragmentManager,
            lifecycle
        )

        binding?.vpSlide1?.adapter = adapter
        binding?.btnConfirm?.setOnClickListener {
        moveTonext()
        }
    }

    private fun moveTonext() {
        var currentPos = binding?.vpSlide1?.currentItem ?: 0
        currentPos++
        if (currentPos < fragmentList.size) {
            binding?.vpSlide1?.currentItem = currentPos
        } else {
            findNavController().navigate(R.id.loginFragment)
        }
    }
}