package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel

//Interface for interacting with domain
interface MovieDomainInteractor {
    //Load movies
    suspend fun loadMovies(): List<MovieDomainModel>?

    //Load movie detail from Id
    suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel?
}