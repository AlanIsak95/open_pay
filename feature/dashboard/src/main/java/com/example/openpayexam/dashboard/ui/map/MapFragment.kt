package com.example.openpayexam.dashboard.ui.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openpayexam.dashboard.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentMapBinding

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root

    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}