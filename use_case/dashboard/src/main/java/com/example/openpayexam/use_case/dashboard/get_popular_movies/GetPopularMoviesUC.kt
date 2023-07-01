package com.example.openpayexam.use_case.dashboard.get_popular_movies

import com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.status.GetPopularMoviesSealed
import com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response.GetPopularMoviesResponse
import com.example.openpayexam.entity_adapter.tools.toPopularList
import com.example.openpayexam.retrofit.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPopularMoviesUC{

    /** */
    fun execute(response : (GetPopularMoviesSealed) -> Unit){

        try {

            RetrofitConnection().getPopularMovies.getPopularMovies().enqueue( object : Callback<GetPopularMoviesResponse>{

                /* */
                override fun onResponse(
                    call: Call<GetPopularMoviesResponse>,
                    response: Response<GetPopularMoviesResponse>
                ) {
                    response(GetPopularMoviesSealed.SUCCESS(response.body()?.results.toPopularList()))
                }

                /* */
                override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
                    response(GetPopularMoviesSealed.FAILURE)
                }

            }

            )

        }catch (e : Exception){
            response(GetPopularMoviesSealed.FAILURE)
        }

    }

}