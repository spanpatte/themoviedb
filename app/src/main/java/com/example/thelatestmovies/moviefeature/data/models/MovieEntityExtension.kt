package com.example.thelatestmovies.moviefeature.data.models

import com.example.thelatestmovies.moviefeature.presentation.MovieModel

//To convert object from MovieDao to MovieModel for View
fun MovieEntity.toMovieModel(): MovieModel =
    MovieModel(
        Id,
        Title,
        Poster
    )