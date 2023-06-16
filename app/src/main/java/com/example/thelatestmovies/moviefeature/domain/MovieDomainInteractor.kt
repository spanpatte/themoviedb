package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
import com.example.thelatestmovies.moviefeature.data.models.MovieEntity

//Interface for interacting with domain
interface MovieDomainInteractor {
    //Load movies
    suspend fun loadMovies(): List<MovieEntity>?

    //Load movie detail from Id
    suspend fun loadMovieDetail(iD: String): MovieDetailEntity?
}