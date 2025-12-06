package com.devsphere.aether.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devsphere.aether.R
import com.devsphere.aether.databinding.FragmentWhatToWearBinding


class WhatToWearFragment : Fragment() {


    private lateinit var _binding: FragmentWhatToWearBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWhatToWearBinding.inflate(inflater, container, false)
        return binding.root

    }


}