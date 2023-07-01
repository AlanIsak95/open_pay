package com.example.openpayexam.retrofit.domain

import com.example.openpayexam.entity_adapter.retrofit.data.getUpComingMovies.response.GetUpComingMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface IGetUpComingMovies {

    @GET("movie/upcoming")
    fun getUpcomingMovies() : Call<GetUpComingMoviesResponse>

}