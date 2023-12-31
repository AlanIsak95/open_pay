package com.example.openpayexam.dashboard.ui.home.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openpayexam.dashboard.status.MoviesTable
import com.example.openpayexam.dashboard.ui.home.status.GetMoviesUIStatus
import com.example.openpayexam.dashboard.ui.home.status.SetMoviesUIStatus
import com.example.openpayexam.entity_adapter.app.entity.movies.Movie
import com.example.openpayexam.entity_adapter.app.entity.movies.status.GetMovies
import com.example.openpayexam.entity_adapter.room.entity.status.SaveMovies
import com.example.openpayexam.entity_adapter.tools.toEntityPopularMovieList
import com.example.openpayexam.entity_adapter.tools.toEntityTopRatedMovieList
import com.example.openpayexam.entity_adapter.tools.toEntityUpcomingMovieList
import com.example.openpayexam.use_case.dashboard.get_data_exists.GetDataExistsUC
import com.example.openpayexam.use_case.dashboard.get_popular_movies.GetPopularMoviesUC
import com.example.openpayexam.use_case.dashboard.get_top_rated_movies.GetTopRatedMoviesUC
import com.example.openpayexam.use_case.dashboard.get_upcoming_movies.GetUpComingMoviesUC
import com.example.openpayexam.use_case.dashboard.set_popular_movies.SetPopularMoviesUC
import com.example.openpayexam.use_case.dashboard.set_top_rated_movies.SetTopRatedMoviesUC
import com.example.openpayexam.use_case.dashboard.set_upcoming_movies.SetUpcomingMoviesUC
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    /* */
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




    /* */
    private val _saveMoviesLiveData = MutableLiveData<SetMoviesUIStatus>()
    val saveMoviesLiveData: LiveData<SetMoviesUIStatus> = _saveMoviesLiveData

    /** */
    fun saveDataMovie(
        popularMoviesList : List<Movie>,
        topRatedMoviesList : List<Movie>,
        upComingMoviesList : List<Movie>,
        context : Context
    ){

        _saveMoviesLiveData.value = SetMoviesUIStatus.Loading

        val savePopularList  = viewModelScope.async {
            SetPopularMoviesUC().execute(popularMoviesList.toEntityPopularMovieList(),context)
        }

        val saveTopRatedList = viewModelScope.async {
            SetTopRatedMoviesUC().execute(topRatedMoviesList.toEntityTopRatedMovieList(),context)
        }

        val saveUpComingList = viewModelScope.async {
            SetUpcomingMoviesUC().execute(upComingMoviesList.toEntityUpcomingMovieList(),context)
        }


        viewModelScope.launch {

            val response = awaitAll(savePopularList,saveTopRatedList,saveUpComingList)

            val savePopularMoviesDeferredSuccess = when (response[0]) {
                is SaveMovies.Failure -> false
                SaveMovies.Success -> true
            }

            val saveTopRatedMoviesDeferredSuccess = when (response[1]) {
                is SaveMovies.Failure -> false
                SaveMovies.Success -> true
            }

            val saveUpcomingMoviesDeferredSuccess = when (response[2]) {
                is SaveMovies.Failure -> false
                SaveMovies.Success -> true
            }

            if (savePopularMoviesDeferredSuccess && saveTopRatedMoviesDeferredSuccess && saveUpcomingMoviesDeferredSuccess) {
                _saveMoviesLiveData.value = SetMoviesUIStatus.Success
                _moviesTableStatusLiveData.value = MoviesTable.HAS_VALUES
            }else
                _saveMoviesLiveData.value = SetMoviesUIStatus.Failure(message = "Execution Error")

            _saveMoviesLiveData.value = SetMoviesUIStatus.HideLoading


        }

    }

    /* */
    private val _moviesTableStatusLiveData = MutableLiveData<MoviesTable>()
    val moviesTableStatusLiveData: LiveData<MoviesTable> = _moviesTableStatusLiveData


    fun validateTableData(context : Context){

        viewModelScope.launch {

            val result = GetDataExistsUC().invoke(context)

            if (result)
                _moviesTableStatusLiveData.value = MoviesTable.HAS_VALUES
            else
                _moviesTableStatusLiveData.value = MoviesTable.EMPTY

        }

    }

}