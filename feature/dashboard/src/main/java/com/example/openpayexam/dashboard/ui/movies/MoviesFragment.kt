package com.example.openpayexam.dashboard.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openpayexam.dashboard.databinding.FragmentMoviesBinding
import com.example.openpayexam.dashboard.ui.movies.adapter.MoviesAdapter
import com.example.openpayexam.dashboard.ui.movies.view_model.MoviesViewModel

class MoviesFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentMoviesBinding

    /* */
    private val moviesViewModel : MoviesViewModel by viewModels()

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

        getDataFromDB()
        setUpObserve()

    }

    /** */
    private fun getDataFromDB() {

        moviesViewModel.getMovies(requireContext())

    }

    /** */
    private fun setUpObserve() {

        /* */
        moviesViewModel.popularListLiveData.observe(viewLifecycleOwner){

            val adapter = MoviesAdapter(it)
            binding.fragmentMoviesRvPopular.adapter = adapter
            binding.fragmentMoviesRvPopular.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        }

        /* */
        moviesViewModel.topRatedListLiveData.observe(viewLifecycleOwner){

            val adapter = MoviesAdapter(it)
            binding.fragmentMoviesRvTopRated.adapter = adapter
            binding.fragmentMoviesRvTopRated.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        }

        /* */
        moviesViewModel.uoComingListLiveData.observe(viewLifecycleOwner){

            val adapter = MoviesAdapter(it)
            binding.fragmentMoviesRvUpComing.adapter = adapter
            binding.fragmentMoviesRvUpComing.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        }

    }

}