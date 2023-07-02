package com.example.openpayexam.entity_adapter.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openpayexam.entity_adapter.room.entity.PopularMovieEntity

@Dao
interface PopularMovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(moviesList : List<PopularMovieEntity>)
    
    @Query("Select * from popular_movies")
    suspend fun getAllMovies():List<PopularMovieEntity>
    
}