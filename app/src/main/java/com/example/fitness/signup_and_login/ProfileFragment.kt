package com.example.fitness.signup_and_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileBinding



class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val gender = listOf("Choose Gender", "Male", "Female")
        binding?.genderSpinner?.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, gender)

        binding?.genderSpinner?.setSelection(0)

        binding?.genderSpinner?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedGender = gender[position]
                    // Handle the selected gender
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }


        binding?.btnProfile?.setOnClickListener {
            findNavController().navigate(R.id.fitnessFragment)

        }
    }

}