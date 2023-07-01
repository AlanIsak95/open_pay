package com.example.openpayexam.dashboard.ui.home.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.response.PopularMovie
import com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.status.GetPopularMoviesSealed
import com.example.openpayexam.use_case.dashboard.get_popular_movies.GetPopularMoviesUC

class HomeViewModel : ViewModel() {

    private val _userLiveData = MutableLiveData<List<PopularMovie>>()
    val userLiveData: LiveData<List<PopularMovie>> = _userLiveData

    /** */
    fun getPopularMovies(){
        GetPopularMoviesUC().execute {
            when(it){
                GetPopularMoviesSealed.FAILURE -> _userLiveData.value = emptyList()
                is GetPopularMoviesSealed.SUCCESS -> _userLiveData.value = it.list
            }
        }
    }


}