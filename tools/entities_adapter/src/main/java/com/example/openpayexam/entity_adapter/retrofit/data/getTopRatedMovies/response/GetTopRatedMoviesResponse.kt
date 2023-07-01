package com.example.openpayexam.entity_adapter.retrofit.data.getTopRatedMovies.response

data class GetTopRatedMoviesResponse(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)