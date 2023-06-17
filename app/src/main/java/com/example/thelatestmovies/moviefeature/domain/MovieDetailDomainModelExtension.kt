package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.presentation.MovieDetailModel


//To convert object from MovieDao to MovieModel for View
fun MovieDetailDomainModel.toMovieDetailModel(): MovieDetailModel =
    MovieDetailModel(
        id,
        original_title,
        original_language,
        overview,
        popularity,
        poster_path,
        release_date,
        vote_count,
        tagline,
        status
    )



