package com.example.openpayexam.use_case.dashboard.get_popular_movies

import com.example.openpayexam.entity_adapter.app.entity.movies.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.toPopularList
import com.example.openpayexam.retrofit.RetrofitConnection

class GetPopularMoviesUC{

    /** */
    suspend fun execute(): GetMovies{

        return try {

            val response = RetrofitConnection().getPopularMovies.getPopularMovies().body()

            return if (response != null)
                GetMovies.SUCCESS(list = response.results.toPopularList())
            else
                GetMovies.FAILURE("Lista Vacia")


        }catch (e : Exception){
            GetMovies.FAILURE("Error : ${e.message}")
        }

    }

}