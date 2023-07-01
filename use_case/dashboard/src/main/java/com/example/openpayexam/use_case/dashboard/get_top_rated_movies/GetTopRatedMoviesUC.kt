package com.example.openpayexam.use_case.dashboard.get_top_rated_movies

import com.example.openpayexam.entity_adapter.app.entity.movies.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.toPopularList
import com.example.openpayexam.entity_adapter.tools.toTopRatedList
import com.example.openpayexam.retrofit.RetrofitConnection


class GetTopRatedMoviesUC {

    /** */
    suspend fun execute(): GetMovies {

        return try {

            val response = RetrofitConnection().getTopRatedMovies.getRatedMovies().body()

            return if (response != null)
                GetMovies.SUCCESS(list = response.results.toTopRatedList())
            else
                GetMovies.FAILURE("Lista Vacia")


        }catch (e : Exception){
            GetMovies.FAILURE("Error : ${e.message}")
        }

    }

}