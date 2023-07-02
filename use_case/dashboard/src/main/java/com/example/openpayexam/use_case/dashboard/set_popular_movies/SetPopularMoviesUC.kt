package com.example.openpayexam.use_case.dashboard.set_popular_movies

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.PopularMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.status.SaveMovies
import com.example.openpayexam.room.AppDataBase

class SetPopularMoviesUC {

    /** */
    suspend fun execute(movieList : List<PopularMovieEntity>, context : Context): SaveMovies {

        return try {
            AppDataBase.getDatabase(context).popularMovieDAO.insertMovies(movieList)
            SaveMovies.Success

        }catch (e : Exception){
            SaveMovies.Failure("Error : ${e.message}")
        }

    }

}