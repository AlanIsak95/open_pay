package com.example.openpayexam.use_case.dashboard.set_top_rated_movies

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.TopRatedMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.status.SaveMovies
import com.example.openpayexam.room.AppDataBase

class SetTopRatedMoviesUC {

    /** */
    suspend fun execute(movieList : List<TopRatedMovieEntity>, context : Context): SaveMovies {

        return try {
            AppDataBase.getDatabase(context).topRatedMovieDAO.insertMovies(movieList)
            SaveMovies.Success

        }catch (e : Exception){
            SaveMovies.Failure("Error : ${e.message}")
        }

    }

}