package com.example.openpayexam.dashboard.ui.home.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.openpayexam.dashboard.databinding.BottomSheeServiceStatusBinding
import com.example.openpayexam.dashboard.ui.home.status.GetMoviesUIStatus
import com.example.openpayexam.dashboard.ui.home.status.SetMoviesUIStatus
import com.example.openpayexam.dashboard.ui.home.view_model.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AlertServiceBottomSheet : BottomSheetDialogFragment() {

    /* */
    private val homeViewModel : HomeViewModel by activityViewModels()

    /** */
    private lateinit var binding : BottomSheeServiceStatusBinding

    /** */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = BottomSheeServiceStatusBinding.inflate(layoutInflater)
        return binding.root

    }

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpListeners()
        setUpObserve()
    }

    /** */
    private fun setUpObserve() {

        /* */
        homeViewModel.getMovieUIStatusLiveData.observe(viewLifecycleOwner) {


            when(it){
                GetMoviesUIStatus.Loading -> {
                    binding.bottomSheetServiceStatusTitleRetrofit.text = "Descargando"
                    binding.bottomSheetServiceStatusSubtitleRetrofit.text = "Descargando Peliculas"
                }
                GetMoviesUIStatus.HideLoading -> binding.bottomSheetServiceStatusTitleRetrofit.text = "Descarga completada"

                is GetMoviesUIStatus.Failure ->
                {
                    binding.bottomSheetServiceStatusSubtitleRetrofit.text = it.message
                    binding.bottomSheetServiceStatusBtnOk.visibility = View.VISIBLE
                    isCancelable = true
                }

                is GetMoviesUIStatus.SUCCESS ->{
                    val movieCount = it.popularList.size + it.topRatedList.size + it.upcomingList.size
                    binding.bottomSheetServiceStatusSubtitleRetrofit.text = "Se han descargado $movieCount peliculas"

                }

            }

        }

        /* */
        homeViewModel.saveMoviesLiveData.observe(viewLifecycleOwner){

            when(it){
                SetMoviesUIStatus.Loading -> {
                    binding.bottomSheetServiceStatusTitleRoom.text = "Guardando"
                    binding.bottomSheetServiceStatusSubtitleRoom.text = "Guardando Peliculas"
                }
                SetMoviesUIStatus.HideLoading -> binding.bottomSheetServiceStatusTitleRoom.text = "Peliculas guardadas"
                is SetMoviesUIStatus.Failure ->{
                    binding.bottomSheetServiceStatusBtnOk.visibility = View.VISIBLE
                    binding.bottomSheetServiceStatusSubtitleRoom.text = it.message
                    isCancelable = true
                }
                SetMoviesUIStatus.Success ->{
                    isCancelable = true
                    binding.bottomSheetServiceStatusBtnOk.visibility = View.VISIBLE
                    binding.bottomSheetServiceStatusSubtitleRoom.text = "Se han guardado todas las peliculas"
                }
            }

        }

    }

    /** */
    private fun setUpView() {
        isCancelable = false
    }

    /** */
    private fun setUpListeners() {
        binding.bottomSheetServiceStatusBtnOk.setOnClickListener {
            dismiss()
        }
    }

}