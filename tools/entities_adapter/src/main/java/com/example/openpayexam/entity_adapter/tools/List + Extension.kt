package com.example.openpayexam.entity_adapter.tools

import com.example.openpayexam.entity_adapter.app.entity.movies.Movie
import com.example.openpayexam.entity_adapter.room.entity.PopularMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.TopRatedMovieEntity
import com.example.openpayexam.entity_adapter.room.entity.UpComingMovieEntity

typealias PopularMovies = com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response.Result
typealias TopRatedMovies = com.example.openpayexam.entity_adapter.retrofit.data.getTopRatedMovies.response.Result
typealias UpComingMovies = com.example.openpayexam.entity_adapter.retrofit.data.getUpComingMovies.response.Result

/** */
fun List<PopularMovies>?.toPopularList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<TopRatedMovies>?.toTopRatedList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}


/** */
fun List<UpComingMovies>?.toUpComingList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<PopularMovieEntity>?.popularMoviesToMovieList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<TopRatedMovieEntity>?.topRatedMoviesToMovieList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<UpComingMovieEntity>?.upComingMoviesToMovieList():List<Movie>{

    this?.let {

        val popularList : MutableList<Movie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}


/** */
fun List<Movie>?.toEntityPopularMovieList():List<PopularMovieEntity>{

    this?.let {

        val popularList : MutableList<PopularMovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toPopularMovieEntity())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}

/** */
fun List<Movie>?.toEntityTopRatedMovieList():List<TopRatedMovieEntity>{

    this?.let {

        val popularList : MutableList<TopRatedMovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toTopRatedEntity())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}


/** */
fun List<Movie>?.toEntityUpcomingMovieList():List<UpComingMovieEntity>{

    this?.let {

        val popularList : MutableList<UpComingMovieEntity> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toUpComingMovieEntity())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}


