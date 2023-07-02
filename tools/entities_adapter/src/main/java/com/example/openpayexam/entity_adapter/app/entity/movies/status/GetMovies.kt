package com.example.openpayexam.entity_adapter.app.entity.movies.status

import com.example.openpayexam.entity_adapter.app.entity.movies.Movie


sealed class GetMovies{

    data class FAILURE(val message : String) : GetMovies()
    data class SUCCESS(val list : List<Movie>) : GetMovies()

}
