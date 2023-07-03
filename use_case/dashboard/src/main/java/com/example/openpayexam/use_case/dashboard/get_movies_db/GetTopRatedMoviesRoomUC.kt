package com.example.openpayexam.use_case.dashboard.get_movies_db

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.topRatedMoviesToMovieList
import com.example.openpayexam.room.AppDataBase

class GetTopRatedMoviesRoomUC {

    /** */
    suspend fun get(context : Context): GetMovies {

        return try {
            val list = AppDataBase.getDatabase(context).topRatedMovieDAO.getAllMovies()
            GetMovies.Success(list.topRatedMoviesToMovieList())

        }catch (e : Exception){
            GetMovies.Failure("Error : ${e.message}")
        }

    }

}