package com.example.openpayexam.dashboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.openpayexam.dashboard.databinding.FragmentHomeBinding
import com.example.openpayexam.dashboard.ui.home.view_model.HomeViewModel

class HomeFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentHomeBinding

    /* */
    private val homeViewModel : HomeViewModel by viewModels()

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()
        setOnClickListeners()

    }

    /** */
    private fun setOnClickListeners() {

        /* */
        binding.fragmentHomeBtnDownload.setOnClickListener {
            homeViewModel.getPopularMovies()
        }

    }

    /** */
    private fun setUpListeners() {

        /* */
        homeViewModel.userLiveData.observe(viewLifecycleOwner) {
            binding.fragmentHomeBtnDownload.isEnabled = false
        }

    }

}