package com.example.fitness.signup_and_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentBackHomeBinding


class BackHomeFragment : Fragment() {

    private var binding: FragmentBackHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBackHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnLogin?.setOnClickListener {
            findNavController().navigate(R.id.scrollviewFragment)

        }
    }

}