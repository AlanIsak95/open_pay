package com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.status

import com.example.openpayexam.entity_adapter.app.entity.get_popular_movies.response.PopularMovie


sealed class GetPopularMoviesSealed{

    object FAILURE : GetPopularMoviesSealed()
    data class SUCCESS(val list : List<PopularMovie>) : GetPopularMoviesSealed()

}
