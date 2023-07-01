package com.example.openpayexam.dashboard.ui.home.status

import com.example.openpayexam.entity_adapter.app.entity.movies.MovieEntity

sealed class GetMoviesUIStatus{

    object HideLoading : GetMoviesUIStatus()
    object Loading : GetMoviesUIStatus()
    data class SUCCESS(
        val popularList : List<MovieEntity>,
        val topRatedList : List<MovieEntity>,
        val upcomingList : List<MovieEntity>
        ) : GetMoviesUIStatus()
    data class Failure(val message : String) : GetMoviesUIStatus()

}