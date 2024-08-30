package com.example.egoprojects

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.egoprojects.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navhHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        bottomNav = binding.bottomNav

        bottomNav!!.setOnItemSelectedListener { item ->
            bottomNavigationSelected(item)
        }


    }
    private fun bottomNavigationSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            0 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.homeFragment)
                true
            }
            1 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.givingFragment)
                true
            }
            2 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.happinesFragment)
                true
            }
            3 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.optimismFragment)
                true
            }
            4 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.respectFragment)
                true
            }
            5 -> {
                findNavController(R.id.navhHostFragment).navigate(R.id.kindnessFragment)
                true
            }
            else -> false
        }
    }

}







