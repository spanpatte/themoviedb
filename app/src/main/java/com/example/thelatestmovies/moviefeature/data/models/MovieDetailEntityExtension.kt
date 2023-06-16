package com.example.thelatestmovies.moviefeature.data.models

import com.example.thelatestmovies.moviefeature.presentation.MovieDetailModel


//To convert object from MovieDetailDao to MovieDetailModel for View
fun MovieDetailEntity.toMovieDetailModel(): MovieDetailModel =
    MovieDetailModel(
        Id,
        Title,
        Year,
        Poster,
        Runtime
    )