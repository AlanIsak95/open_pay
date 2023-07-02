package com.example.openpayexam.dashboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.openpayexam.dashboard.R
import com.example.openpayexam.dashboard.databinding.FragmentHomeBinding
import com.example.openpayexam.dashboard.status.MoviesTable
import com.example.openpayexam.dashboard.ui.home.status.GetMoviesUIStatus
import com.example.openpayexam.dashboard.ui.home.status.SetMoviesUIStatus
import com.example.openpayexam.dashboard.ui.home.view_model.HomeViewModel

class HomeFragment : Fragment() {

    /* */
    private lateinit var binding : FragmentHomeBinding

    /* */
    private val homeViewModel : HomeViewModel by activityViewModels()

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
            findNavController().navigate(R.id.action_homeFragment_to_alertServiceBottomSheet)
        }

    }

    /** */
    private fun setUpListeners() {

        /* */
        homeViewModel.getMovieUIStatusLiveData.observe(viewLifecycleOwner) {

            when(it){
                GetMoviesUIStatus.Loading -> binding.fragmentHomeBtnDownload.isEnabled = false
                GetMoviesUIStatus.HideLoading -> {/* BY PASS*/ }
                is GetMoviesUIStatus.Failure -> binding.fragmentHomeBtnDownload.isEnabled = true
                is GetMoviesUIStatus.SUCCESS -> saveData(it)
            }

        }

        /* */
        homeViewModel.saveMoviesLiveData.observe(viewLifecycleOwner){

            when(it){
                SetMoviesUIStatus.HideLoading ->
                    binding.fragmentHomeBtnDownload.isEnabled = true
                else ->{/* BY PASS */}
            }

        }

        /* */
        homeViewModel.moviesTableStatusLiveData.observe(viewLifecycleOwner){
            when(it){
                MoviesTable.HAS_VALUES -> {
                    binding.fragmentHomeBtnDownload.visibility = View.GONE
                    binding.fragmentHomeTitle.visibility = View.VISIBLE
                    binding.fragmentHomeTitle.text = "Los Datos ya se han guardado"
                }
                else -> {
                    binding.fragmentHomeBtnDownload.visibility = View.VISIBLE
                    binding.fragmentHomeTitle.text = "Descarga la informacion"
                    binding.fragmentHomeTitle.visibility = View.VISIBLE

                }
            }
        }

    }

    /** */
    private fun saveData(it: GetMoviesUIStatus.SUCCESS) {

        /* */
        homeViewModel.saveDataMovie(
            popularMoviesList = it.popularList,
            topRatedMoviesList = it.topRatedList,
            upComingMoviesList = it.upcomingList,
            context = requireContext()
        )

    }

}