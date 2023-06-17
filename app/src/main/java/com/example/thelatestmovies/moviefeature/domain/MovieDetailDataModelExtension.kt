package com.example.thelatestmovies.moviefeature.data.models

import com.example.thelatestmovies.moviefeature.domain.DomainConfigs
import com.example.thelatestmovies.moviefeature.domain.MovieDetailDomainModel
import com.example.thelatestmovies.moviefeature.presentation.MovieDetailModel


//To convert object from MovieDetailDao to MovieDetailModel for View
fun MovieDetailDataModel.toMovieDetailDomainModel(): MovieDetailDomainModel =
    MovieDetailDomainModel(
        id,
        original_title,
        original_language,
        overview,
        popularity,
        DomainConfigs.imagePathBaseUrl + poster_path,
        release_date,
        vote_count,
        tagline,
        status
    )

