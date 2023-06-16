package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
import com.example.thelatestmovies.moviefeature.data.models.MovieEntity
import com.example.thelatestmovies.moviefeature.data.repos.MovieRepoInteractor


class MovieDomainInteractorImpl(private var movieRepoInteractor: MovieRepoInteractor) :
    MovieDomainInteractor {

    //Load movies
    override suspend fun loadMovies(): List<MovieEntity>? {
        return movieRepoInteractor.loadMovies()
    }

    //Load movie detail
    override suspend fun loadMovieDetail(iD: String): MovieDetailEntity? {
        return movieRepoInteractor.loadMovieDetail(iD)
    }
}