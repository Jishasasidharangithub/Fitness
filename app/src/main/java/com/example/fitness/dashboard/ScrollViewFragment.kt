package com.example.fitness.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentScrollViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ScrollViewFragment : Fragment() {

    private var binding: FragmentScrollViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScrollViewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.ivNotification?.setOnClickListener {
            findNavController().navigate(R.id.notificationFragment)
        }

        binding?.cvStatusCard?.setOnClickListener {
            findNavController().navigate(R.id.activitytrackerFragment)
        }

        binding?.ivWorkOutSection?.setOnClickListener {
            findNavController().navigate(R.id.workouttrackerscrollviewFragment)
        }

        }

}