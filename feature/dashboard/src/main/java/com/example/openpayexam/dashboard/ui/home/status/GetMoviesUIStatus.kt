package com.example.openpayexam.dashboard.ui.home.status

import com.example.openpayexam.entity_adapter.app.entity.movies.Movie

sealed class GetMoviesUIStatus{

    object HideLoading : GetMoviesUIStatus()
    object Loading : GetMoviesUIStatus()
    data class SUCCESS(
        val popularList : List<Movie>,
        val topRatedList : List<Movie>,
        val upcomingList : List<Movie>
        ) : GetMoviesUIStatus()
    data class Failure(val message : String) : GetMoviesUIStatus()

}