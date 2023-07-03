package com.example.openpayexam.dashboard.ui.movies.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openpayexam.entity_adapter.app.entity.movies.Movie
import com.example.openpayexam.entity_adapter.room.entity.status.GetMovies
import com.example.openpayexam.use_case.dashboard.get_movies_db.GetPopularMoviesRoomUC
import com.example.openpayexam.use_case.dashboard.get_movies_db.GetTopRatedMoviesRoomUC
import com.example.openpayexam.use_case.dashboard.get_movies_db.GetUpComingMoviesRoomUC
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    /* */
    private val _popularListLiveData = MutableLiveData<List<Movie>>()
    val popularListLiveData: LiveData<List<Movie>> = _popularListLiveData

    /* */
    private val _topRatedListLiveData = MutableLiveData<List<Movie>>()
    val topRatedListLiveData: LiveData<List<Movie>> = _topRatedListLiveData

    /* */
    private val _upComingListLiveData = MutableLiveData<List<Movie>>()
    val uoComingListLiveData: LiveData<List<Movie>> = _upComingListLiveData


    fun getMovies(context : Context){

        viewModelScope.launch {

            when(val result = GetPopularMoviesRoomUC().get(context)){
                is GetMovies.Failure -> _popularListLiveData.value = emptyList()
                is GetMovies.Success -> _popularListLiveData.value = result.list
            }

        }

        viewModelScope.launch {

            when(val result = GetTopRatedMoviesRoomUC().get(context)){
                is GetMovies.Failure -> _topRatedListLiveData.value = emptyList()
                is GetMovies.Success -> _topRatedListLiveData.value = result.list
            }

        }

        viewModelScope.launch {

            when(val result = GetUpComingMoviesRoomUC().get(context)){
                is GetMovies.Failure -> _upComingListLiveData.value = emptyList()
                is GetMovies.Success -> _upComingListLiveData.value = result.list
            }

        }

    }

}