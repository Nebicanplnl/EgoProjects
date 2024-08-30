package com.example.egoprojects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.egoprojects.databinding.FragmentHomeBinding

class OptimismFragment : Fragment(R.layout.fragment_optimism) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_optimism, container, false)
    }
}