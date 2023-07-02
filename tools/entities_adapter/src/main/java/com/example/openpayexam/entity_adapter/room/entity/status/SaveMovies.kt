package com.example.openpayexam.entity_adapter.room.entity.status

sealed class SaveMovies{

    data class Failure(val message : String) : SaveMovies()
    object Success : SaveMovies()

}
