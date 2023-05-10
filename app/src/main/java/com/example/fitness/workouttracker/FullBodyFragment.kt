package com.example.fitness.workouttracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness.R
import com.example.fitness.databinding.FragmentFullBodyBinding
import com.example.fitness.utils.logThis


class FullBodyFragment : Fragment(), SubModelItemAdapter.SubModelItemListener {

    private var binding: FragmentFullBodyBinding? = null
    private val execricesItemAdapter: ExecricesItemAdapter by lazy { ExecricesItemAdapter() }
    private val mainModelItemAdapter: MainModelItemAdapter by lazy { MainModelItemAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            FragmentFullBodyBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding?.root
    }

    private var execricesItem = mutableListOf<ExecricesItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setData()
        execerise()
        execeriseData()

        binding?.ivScheduleCalnder?.setOnClickListener {
            findNavController().navigate(R.id.workoutscheduleFragment)

        }

    }

    fun init() {
        binding?.rvWorkOutItemContent?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = execricesItemAdapter
        }
    }

    fun setData() {
        execricesItem.addAll(
            listOf(
                ExecricesItem(R.drawable.barbell, "Bar bell"),
                ExecricesItem(R.drawable.skippingrope, "Skipping Rope")
            )
        )
        execricesItemAdapter.updateList(execricesItem)
    }

    fun execerise() {
        binding?.rvSet?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainModelItemAdapter
        }
    }

    fun execeriseData() {
        val subList = listOf(
            SubModelItemRecycler(
                R.drawable.set1image1,
                "Warm Up",
                "05:00"
            ), SubModelItemRecycler(
                R.drawable.set1image2,
                "Jumping Jack",
                "12x"
            ), SubModelItemRecycler(
                R.drawable.set1image3,
                "Skipping",
                "15x"
            ), SubModelItemRecycler(
                R.drawable.set1image4,
                "Squats",
                "20x"
            ), SubModelItemRecycler(
                R.drawable.set1image5,
                "Arm Raises",
                "00:53"
            ), SubModelItemRecycler(
                R.drawable.set1image6,
                "Rest and Drink",
                "02:00"
            )
        )

        val subList1 = listOf(
            SubModelItemRecycler(
                R.drawable.set2image1,
                "Incline Push-Ups",
                "12x"
            ), SubModelItemRecycler(
                R.drawable.set2image2,
                "Push-Ups",
                "15x"
            )
        )
        val mainList = listOf(
            MainModelItemRecycler("set1", subList),
            MainModelItemRecycler("set2", subList1),
        )

        mainModelItemAdapter.updateList(mainList)
    }

    override fun viewMoreClick(submodelItem: SubModelItemRecycler) {
        findNavController().navigate(R.id.jampingjackFragment)
    }



}