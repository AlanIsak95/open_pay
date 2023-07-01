package com.example.openpayexam.dashboard.ui.home.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openpayexam.dashboard.ui.home.status.GetMoviesUIStatus
import com.example.openpayexam.entity_adapter.app.entity.movies.status.GetMovies
import com.example.openpayexam.use_case.dashboard.get_popular_movies.GetPopularMoviesUC
import com.example.openpayexam.use_case.dashboard.get_top_rated_movies.GetTopRatedMoviesUC
import com.example.openpayexam.use_case.dashboard.get_upcoming_movies.GetUpComingMoviesUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    /** */
    private val _getMovieUIStatusLiveData = MutableLiveData<GetMoviesUIStatus>()
    val getMovieUIStatusLiveData: LiveData<GetMoviesUIStatus> = _getMovieUIStatusLiveData


    /** */
    fun getPopularMovies(){

        _getMovieUIStatusLiveData.value = GetMoviesUIStatus.Loading


        val popularMoviesDeferred = viewModelScope.async{
            GetPopularMoviesUC().execute()
        }

        val topRatedMoviesDeferred = viewModelScope.async{
            GetTopRatedMoviesUC().execute()
        }

        val upComingMoviesDeferred = viewModelScope.async{
            GetUpComingMoviesUC().execute()
        }


        viewModelScope.launch {


            val result = awaitAll(popularMoviesDeferred,topRatedMoviesDeferred,upComingMoviesDeferred)

            /* */
            val popularList =
                when(val value = result[0]){
                    is GetMovies.FAILURE -> emptyList()
                    is GetMovies.SUCCESS -> value.list
            }


            /* */
            val topRatedList =
                when(val value = result[1]){
                    is GetMovies.FAILURE -> emptyList()
                    is GetMovies.SUCCESS -> value.list
                }

            /* */
            val upcomingList =
                when(val value = result[2]){
                    is GetMovies.FAILURE -> emptyList()
                    is GetMovies.SUCCESS -> value.list
                }

            _getMovieUIStatusLiveData.value = GetMoviesUIStatus.SUCCESS(
                popularList = popularList,
                topRatedList = topRatedList,
                upcomingList = upcomingList
            )


            _getMovieUIStatusLiveData.value = GetMoviesUIStatus.HideLoading

        }

    }


}