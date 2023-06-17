package com.example.thelatestmovies.moviefeature.data.models


data class MovieDataModelResponse(
    val page: Int,
    val results: List<MovieDataModel>
)
data class MovieDataModel(
    val id: Int,
    val original_title: String,
    val poster_path: String
)
