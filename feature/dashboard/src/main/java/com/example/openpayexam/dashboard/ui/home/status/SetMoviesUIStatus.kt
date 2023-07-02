package com.example.openpayexam.dashboard.ui.home.status

sealed class SetMoviesUIStatus {

    object HideLoading : SetMoviesUIStatus()
    object Loading : SetMoviesUIStatus()
    object Success : SetMoviesUIStatus()
    data class Failure(val message : String) : SetMoviesUIStatus()

}