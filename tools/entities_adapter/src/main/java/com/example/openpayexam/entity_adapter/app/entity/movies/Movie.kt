package com.example.openpayexam.entity_adapter.app.entity.movies

import com.example.openpayexam.entity_adapter.room.entity.PopularMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.TopRatedMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.UpComingMovieEntity

data class Movie(
    val adult: Boolean?,
    val backdrop_path: String?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
){

    /** */
    fun toTopRatedEntity(): TopRatedMovieEntity
    {
        return TopRatedMovieEntity(
            adult = adult,
            backdrop_path = backdrop_path,
            id = id,
            original_language = original_language,
            original_title= original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path,
            release_date = release_date,
            title = title,
            video = video,
            vote_average = vote_average,
            vote_count = vote_count
        )
    }

    /** */
    fun toPopularMovieEntity(): PopularMovieEntity
    {
        return PopularMovieEntity(
            adult = adult,
            backdrop_path = backdrop_path,
            id = id,
            original_language = original_language,
            original_title= original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path,
            release_date = release_date,
            title = title,
            video = video,
            vote_average = vote_average,
            vote_count = vote_count
        )
    }


    /** */
    fun toUpComingMovieEntity(): UpComingMovieEntity
    {
        return UpComingMovieEntity(
            adult = adult,
            backdrop_path = backdrop_path,
            id = id,
            original_language = original_language,
            original_title= original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path,
            release_date = release_date,
            title = title,
            video = video,
            vote_average = vote_average,
            vote_count = vote_count
        )
    }



}
