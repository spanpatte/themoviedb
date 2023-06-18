package com.spanpatte.thelatestmovies.moviefeature.domain

import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.domain.models.DomainConfigs
import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDomainModel

//To convert object from MovieDao to MovieModel for View
fun MovieDataModel.toMovieDomainModel(): MovieDomainModel =
    MovieDomainModel(
        id,
        original_title,
        DomainConfigs.imagePathBaseUrl + poster_path,
    )