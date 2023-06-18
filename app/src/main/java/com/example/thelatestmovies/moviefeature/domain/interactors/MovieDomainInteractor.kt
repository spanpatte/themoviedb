package com.example.thelatestmovies.moviefeature.domain.interactors

import android.content.Context
import com.example.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDomainModel

//Interface for interacting with domain
interface MovieDomainInteractor {
    //Load movies
    suspend fun loadMovies(): List<MovieDomainModel>?

    //Load movie detail from Id
    suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel?
}