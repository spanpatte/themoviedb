package com.example.thelatestmovies.moviefeature.data.models

import com.example.thelatestmovies.moviefeature.domain.MovieDomainModel
import com.example.thelatestmovies.moviefeature.presentation.MovieModel

//To convert object from MovieDao to MovieModel for View
fun MovieDataModel.toMovieDomainModel(): MovieDomainModel =
    MovieDomainModel(
        id,
        original_title,
        poster_path,

    )