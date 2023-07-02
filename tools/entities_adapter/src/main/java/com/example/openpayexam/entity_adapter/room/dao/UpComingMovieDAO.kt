package com.example.openpayexam.entity_adapter.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.openpayexam.entity_adapter.room.entity.UpComingMovieEntity

@Dao
interface UpComingMovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(moviesList : List<UpComingMovieEntity>)

    @Query("Select * from upcoming_movies")
    suspend fun getAllMovies():List<UpComingMovieEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM upcoming_movies LIMIT 1)")
    suspend fun hasValues(): Boolean

}