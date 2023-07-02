package com.example.openpayexam.entity_adapter.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openpayexam.entity_adapter.room.entity.TopRatedMovieEntity

@Dao
interface TopRatedMovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(moviesList : List<TopRatedMovieEntity>)

    @Query("Select * from top_rated_movies")
    suspend fun getAllMovies():List<TopRatedMovieEntity>

}