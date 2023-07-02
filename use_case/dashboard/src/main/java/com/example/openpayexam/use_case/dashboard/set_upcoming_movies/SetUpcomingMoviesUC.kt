package com.example.openpayexam.use_case.dashboard.set_upcoming_movies

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.UpComingMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.status.SaveMovies
import com.example.openpayexam.room.AppDataBase

class SetUpcomingMoviesUC {

    /** */
    suspend fun execute(movieList : List<UpComingMovieEntity>, context : Context): SaveMovies {

        return try {
            AppDataBase.getDatabase(context).upComingMovieDAO.insertMovies(movieList)
            SaveMovies.Success

        }catch (e : Exception){
            SaveMovies.Failure("Error : ${e.message}")
        }

    }

}