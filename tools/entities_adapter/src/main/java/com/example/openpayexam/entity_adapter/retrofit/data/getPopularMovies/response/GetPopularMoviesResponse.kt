package com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response

data class GetPopularMoviesResponse(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)