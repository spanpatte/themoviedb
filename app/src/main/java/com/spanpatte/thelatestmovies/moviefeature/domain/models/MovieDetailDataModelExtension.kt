package com.spanpatte.thelatestmovies.moviefeature.data.models

import com.spanpatte.thelatestmovies.moviefeature.domain.models.DomainConfigs
import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel


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

