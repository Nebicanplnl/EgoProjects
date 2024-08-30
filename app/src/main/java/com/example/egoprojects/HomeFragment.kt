package com.example.egoprojects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.egoprojects.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: ViewModel2 by viewModels()

    private val bottomNav: BottomNavigationView? get() = (activity as? MainActivity)?.bottomNav

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.switchStates.observe(viewLifecycleOwner, Observer { switchStates ->
//            val switches = listOf(
//                binding.switchGiving,
//                binding.switchHappines,
//                binding.switchKindness,
//                binding.switchRespect,
//                binding.switchOptimism
//            )
//            switches.forEach {
//          //      it.isEnabled = switchStates.isEgoBottonEnabled
//            }
//
//
//
//        })
//        viewModel.navigationItems.observe(viewLifecycleOwner, Observer { items ->
//            bottomNav?.menu?.clear()
//            items.forEach { item ->
//                bottomNav?.menu?.add(Menu.NONE, item.id, Menu.NONE, item.description)?.setIcon(item.icon)
//            }
//        })

        binding.switchEgo.isChecked = true
        controlBottomNavigationBar(binding.switchEgo.isChecked)
        isEnabledSwitches(binding.switchEgo.isChecked)

        binding.switchEgo.setOnCheckedChangeListener { _, isChecked ->
           // viewModel.isEgoBottonEnabled(isChecked)
            controlBottomNavigationBar(isChecked)
            addBottomNavigationItem(isSwitchEgoItem = true)
            isEnabledSwitches(isChecked)
        }
        binding.switchGiving.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(
                    bottomNavDescription = "Giving",
                    index = 1,
                    menuIcon = R.drawable.ic_giving,

                )
            } else {
                deleteBottomNavigationItem(index = 1)
            }
        }
        binding.switchOptimism.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(
                    bottomNavDescription = "Optimism",
                    index = 2,
                    menuIcon = R.drawable.ic_optimism,

                )
            } else {
                deleteBottomNavigationItem(index = 2)
            }
        }
        binding.switchRespect.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(
                    bottomNavDescription = "Respect",
                    index = 3,
                    menuIcon = R.drawable.ic_respec,

                )
            } else {
                deleteBottomNavigationItem(index = 3)
            }

        }
        binding.switchHappines.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(
                    bottomNavDescription = "Happines",
                    index = 4,
                    menuIcon = R.drawable.ic_hands,

                )
            } else {
                deleteBottomNavigationItem(index = 4)
            }

        }
        binding.switchKindness.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(
                    bottomNavDescription = "Kindness",
                    index = 5,
                    menuIcon = R.drawable.ic_kindness,
                )
            } else {
                deleteBottomNavigationItem(index = 5)
            }
        }
    }


    private fun isEnabledSwitches(checked: Boolean) {
        val switches = listOf(
            binding.switchGiving,
            binding.switchHappines,
            binding.switchKindness,
            binding.switchRespect,
            binding.switchOptimism
        )
        switches.forEach {
            it.isEnabled = checked.not()
        }
        if (checked) {
            switches.forEach { switches ->
                switches.isChecked = false
                switches.isEnabled = false

            }

        } else {
            switches.forEach { switches ->
                switches.isEnabled = true
            }
        }

    }

    private fun deleteBottomNavigationItem(index: Int) {

        bottomNav!!.menu.removeItem(index)
    }

    private fun controlBottomNavigationBar(isEgoChecked: Boolean) {

        if (isEgoChecked) {
            bottomNav!!.visibility = View.GONE
        } else {
            bottomNav!!.visibility = View.VISIBLE
            addBottomNavigationItem(isEgoChecked)
        }
    }

    private fun addBottomNavigationItem(
        isSwitchEgoItem: Boolean = false,
        bottomNavDescription: String = "EgoSwitch",
        index: Int = 0,
        menuIcon: Int = R.drawable.baseline_egg_24,
    ) {

        val menu = bottomNav!!.menu

        if (menu.size() > 4 && !isSwitchEgoItem) {
            Toast.makeText(requireContext(), "Too many items", Toast.LENGTH_SHORT).show()
            return
        }


        if (isSwitchEgoItem) {
            menu.clear()
            val egoSwitchItem = menu.add(Menu.NONE, index, Menu.NONE, bottomNavDescription)
            egoSwitchItem.setIcon(menuIcon)
        } else {
            menu.add(Menu.NONE, index, Menu.NONE, bottomNavDescription).setIcon(menuIcon)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



