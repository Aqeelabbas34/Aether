package com.devsphere.aether.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devsphere.aether.R
import com.devsphere.aether.databinding.FragmentLocationsBinding

class LocationsFragment : Fragment() {


    private lateinit var _binding: FragmentLocationsBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root

    }


}