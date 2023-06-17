package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.presentation.MovieModel

//To convert object from MovieDao to MovieModel for View
fun MovieDomainModel.toMovieModel(): MovieModel =
    MovieModel(
        id,
        original_title,
        poster_path

    )