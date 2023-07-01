package com.example.openpayexam.entity_adapter.tools

import com.example.openpayexam.entity_adapter.app.entity.movies.MovieEntity

typealias PopularMovies = com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response.Result
typealias TopRatedMovies = com.example.openpayexam.entity_adapter.retrofit.data.getTopRatedMovies.response.Result
typealias UpComingMovies = com.example.openpayexam.entity_adapter.retrofit.data.getUpComingMovies.response.Result

/** */
fun List<PopularMovies>?.toPopularList():List<MovieEntity>{

    this?.let {

        val popularList : MutableList<MovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<TopRatedMovies>?.toTopRatedList():List<MovieEntity>{

    this?.let {

        val popularList : MutableList<MovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}


/** */
fun List<UpComingMovies>?.toUpComingList():List<MovieEntity>{

    this?.let {

        val popularList : MutableList<MovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}