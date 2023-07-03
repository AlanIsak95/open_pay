package com.example.openpayexam.use_case.dashboard.get_movies_db

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.upComingMoviesToMovieList
import com.example.openpayexam.room.AppDataBase

class GetUpComingMoviesRoomUC {

    /** */
    suspend fun get(context : Context): GetMovies {

        return try {
            val list = AppDataBase.getDatabase(context).upComingMovieDAO.getAllMovies()
            GetMovies.Success(list.upComingMoviesToMovieList())

        }catch (e : Exception){
            GetMovies.Failure("Error : ${e.message}")
        }

    }

}