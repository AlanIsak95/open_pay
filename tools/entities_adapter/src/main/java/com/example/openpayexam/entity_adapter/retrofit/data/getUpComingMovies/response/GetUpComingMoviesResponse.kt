package com.example.openpayexam.entity_adapter.retrofit.data.getUpComingMovies.response

data class GetUpComingMoviesResponse(
    val dates: Dates?,
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)