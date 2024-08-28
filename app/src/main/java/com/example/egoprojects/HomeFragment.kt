package com.example.egoprojects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.egoprojects.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.switchEgo.isChecked = true
        controlBottomNavigationBar(binding.switchEgo.isChecked)
        isEnabledSwitches(binding.switchEgo.isChecked)

        binding.switchEgo.setOnCheckedChangeListener { _, isChecked ->
            controlBottomNavigationBar(isChecked)
            addBottomNavigationItem(isSwitchEgoItem = true)
            isEnabledSwitches(isChecked)
        }
        binding.switchGiving.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(bottomNavDescription = "g", index = 1, menuIcon = R.drawable.ic_giving )
            }else{
                deleteBottomNavigationItem(index = 1)
            }
        }
        binding.switchOptimism.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                addBottomNavigationItem(bottomNavDescription = "o", index = 2, menuIcon = R.drawable.ic_optimism )
            }else {
                deleteBottomNavigationItem(index = 2)
            }
        }
        binding.switchRespect.setOnCheckedChangeListener { _, isChecked ->
            addBottomNavigationItem(bottomNavDescription = "r", index = 3, menuIcon = R.drawable.ic_respec )
        }
        binding.switchHappines.setOnCheckedChangeListener { _, isChecked ->
            addBottomNavigationItem(bottomNavDescription = "h", index = 4, menuIcon = R.drawable.ic_hands )
        }
        binding.switchKindness.setOnCheckedChangeListener { _, isChecked ->
            addBottomNavigationItem(bottomNavDescription = "k", index = 5, menuIcon = R.drawable.ic_kindness )
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
        switches.forEach{
            it.isEnabled = checked.not()
        }

    }

    private fun deleteBottomNavigationItem(index: Int) {
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView.menu.removeItem(index)
    }

    private fun controlBottomNavigationBar(isEgoChecked: Boolean) {
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)
        if (isEgoChecked) {
            bottomNavigationView.visibility = View.GONE
        } else {
            bottomNavigationView.visibility = View.VISIBLE
            addBottomNavigationItem(isEgoChecked, )
        }
    }



    private fun addBottomNavigationItem(isSwitchEgoItem: Boolean = false, bottomNavDescription: String = "EgoSwitch", index: Int = 0, menuIcon: Int = R.drawable.baseline_egg_24) {
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)
        val menu = bottomNavigationView.menu


        if (menu.size() > 4) {
            Toast.makeText(requireContext(), "Bottom navigation menu is full",Toast.LENGTH_SHORT).show()
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





