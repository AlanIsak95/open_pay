package com.example.openpayexam.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.openpayexam.entity_adapter.room.entity.PopularMovieEntity
import com.example.openpayexam.entity_adapter.room.dao.PopularMovieDAO
import com.example.openpayexam.entity_adapter.room.dao.TopRatedMovieDAO
import com.example.openpayexam.entity_adapter.room.dao.UpComingMovieDAO
import com.example.openpayexam.entity_adapter.room.entity.TopRatedMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.UpComingMovieEntity

@Database(
    entities = [PopularMovieEntity::class, TopRatedMovieEntity::class, UpComingMovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase(){

    /* */
    abstract val popularMovieDAO: PopularMovieDAO

    /* */
    abstract val topRatedMovieDAO: TopRatedMovieDAO

    /* */
    abstract val upComingMovieDAO: UpComingMovieDAO

    companion object {

        private const val DATABASE_NAME = "open_pay_db"

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }

}