package com.example.openpayexam.use_case.dashboard.get_movies_db

import android.content.Context
import com.example.openpayexam.entity_adapter.room.entity.status.GetMovies
import com.example.openpayexam.entity_adapter.tools.popularMoviesToMovieList
import com.example.openpayexam.room.AppDataBase

class GetPopularMoviesRoomUC {

    /** */
    suspend fun get(context : Context): GetMovies {

        return try {
            val list = AppDataBase.getDatabase(context).popularMovieDAO.getAllMovies()
            GetMovies.Success(list.popularMoviesToMovieList())

        }catch (e : Exception){
            GetMovies.Failure("Error : ${e.message}")
        }

    }

}