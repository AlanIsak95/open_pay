package com.example.openpayexam.use_case.dashboard.get_upcoming_movies

import com.example.openpayexam.entity_adapter.app.entity.movies.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.toUpComingList
import com.example.openpayexam.retrofit.RetrofitConnection

class GetUpComingMoviesUC {

    /** */
    suspend fun execute(): GetMovies {

        return try {

            val response = RetrofitConnection().getUpcomingMovies.getUpcomingMovies().body()

            return if (response != null)
                GetMovies.SUCCESS(list = response.results.toUpComingList())
            else
                GetMovies.FAILURE("Lista Vacia")

        }catch (e : Exception){
            GetMovies.FAILURE("Error : ${e.message}")
        }

    }
}