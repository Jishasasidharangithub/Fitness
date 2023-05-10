package com.example.fitness.onboardig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentViewPagerBinding
import com.example.fitness.screen.FirstScreen
import com.example.fitness.screen.FourthScreen
import com.example.fitness.screen.SecondScreen
import com.example.fitness.screen.ThirdScreen

class ViewPagerFragment : Fragment() {

    private var binding: FragmentViewPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        return binding?.root
    }
    val fragmentList = arrayListOf<Fragment>(
        FirstScreen(),
        SecondScreen(),
        ThirdScreen(),
        FourthScreen()
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdaptor(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding?.viewPager?.adapter = adapter

        binding?.next1?.setOnClickListener {
            moveTonext()
        }
    }

    private fun moveTonext() {
        var currentPos=binding?.viewPager?.currentItem ?: 0
        currentPos++
        if (currentPos < fragmentList.size){
            binding?.viewPager?.currentItem = currentPos
        }else{
            findNavController().navigate(R.id.registerFragment)
        }
    }

}