package com.spanpatte.thelatestmovies.moviefeature.presentation.models

//Model for view to display movie details
data class
MovieDetailModel(
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
