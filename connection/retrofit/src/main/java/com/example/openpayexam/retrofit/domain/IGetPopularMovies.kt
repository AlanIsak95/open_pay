package com.example.openpayexam.retrofit.domain

import com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response.GetPopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface IGetPopularMovies {

    @GET("movie/popular")
    fun getPopularMovies() : Call<GetPopularMoviesResponse>

}