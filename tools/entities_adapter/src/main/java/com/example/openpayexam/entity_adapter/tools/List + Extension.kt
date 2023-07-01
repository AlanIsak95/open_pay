package com.example.openpayexam.entity_adapter.tools

import com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.response.PopularMovie
import com.example.openpayexam.entity_adapter.retrofit.data.getPopularMovies.response.Result


fun List<Result>?.toPopularList():List<PopularMovie>{

    this?.let {

        val popularList : MutableList<PopularMovie> = mutableListOf()

        it.forEach{item ->
            popularList.add(item.toPopularMovie())
        }

        return popularList

    }?:run{
        return mutableListOf()
    }

}