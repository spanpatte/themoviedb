package com.example.thelatestmovies.moviefeature.data.models

//Dao retrieved from remote source or database
data class
MovieDetailDataModel(
    val id: Int,
    val original_title: String,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val vote_count: Int,
    val tagline: String,
    val status: String
)
