package com.example.openpayexam.retrofit.domain

import com.example.openpayexam.entity_adapter.retrofit.data.getTopRatedMovies.response.GetTopRatedMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface IGetTopRatedMovies {

    @GET("movie/top_rated")
    fun getRatedMovies() : Call<GetTopRatedMoviesResponse>

}