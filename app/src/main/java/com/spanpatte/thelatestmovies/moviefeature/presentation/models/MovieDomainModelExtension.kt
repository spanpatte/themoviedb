package com.spanpatte.thelatestmovies.moviefeature.domain

import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDomainModel
import com.spanpatte.thelatestmovies.moviefeature.presentation.models.MovieModel

//To convert object from MovieDao to MovieModel for View
fun MovieDomainModel.toMovieModel(): MovieModel =
    MovieModel(
        id,
        original_title,
        poster_path
    )