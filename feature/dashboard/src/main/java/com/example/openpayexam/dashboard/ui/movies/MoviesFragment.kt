package com.example.openpayexam.dashboard.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openpayexam.dashboard.R
import com.example.openpayexam.dashboard.databinding.FragmentGalleryBinding
import com.example.openpayexam.dashboard.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentMoviesBinding

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMoviesBinding.inflate(layoutInflater)
        return binding.root

    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}