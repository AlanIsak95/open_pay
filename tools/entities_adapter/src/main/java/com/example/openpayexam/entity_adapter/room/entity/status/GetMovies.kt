package com.example.openpayexam.entity_adapter.room.entity.status

import com.example.openpayexam.entity_adapter.app.entity.movies.Movie

sealed class GetMovies{

    data class Failure(val message : String) : GetMovies()
    data class Success(val list : List<Movie>) : GetMovies()

}
