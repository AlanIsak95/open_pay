package com.example.openpayexam.retrofit

import com.example.openpayexam.retrofit.domain.IGetPopularMovies
import com.example.openpayexam.retrofit.domain.IGetTopRatedMovies
import com.example.openpayexam.retrofit.domain.IGetUpComingMovies
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection {

    /** */
    private val client = OkHttpClient.Builder()
        .addInterceptor(RetrofitInterceptor())
        .build()

    /** */
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val getPopularMovies:  IGetPopularMovies  = retrofit.create(IGetPopularMovies::class.java)
    val getTopRatedMovies: IGetTopRatedMovies = retrofit.create(IGetTopRatedMovies::class.java)
    val getUpcomingMovies: IGetUpComingMovies = retrofit.create(IGetUpComingMovies::class.java)

}