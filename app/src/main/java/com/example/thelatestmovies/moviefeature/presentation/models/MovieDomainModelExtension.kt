package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.domain.models.MovieDomainModel
import com.example.thelatestmovies.moviefeature.presentation.models.MovieModel

//To convert object from MovieDao to MovieModel for View
fun MovieDomainModel.toMovieModel(): MovieModel =
    MovieModel(
        id,
        original_title,
        poster_path
    )