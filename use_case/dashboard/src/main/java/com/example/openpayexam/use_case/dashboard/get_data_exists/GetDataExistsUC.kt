package com.example.openpayexam.use_case.dashboard.get_data_exists

import android.content.Context
import com.example.openpayexam.room.AppDataBase

class GetDataExistsUC {

    suspend operator fun invoke(context : Context): Boolean {

        return try {

            val popularMoviesListHasValues =
                AppDataBase.getDatabase(context).popularMovieDAO.hasValues()
            val topRatedMoviesListHasValues =
                AppDataBase.getDatabase(context).topRatedMovieDAO.hasValues()
            val upComingMoviesListHasValues =
                AppDataBase.getDatabase(context).upComingMovieDAO.hasValues()

            popularMoviesListHasValues && topRatedMoviesListHasValues && upComingMoviesListHasValues


        } catch (e: Exception) {
            false
        }

    }

}