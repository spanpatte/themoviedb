package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel


class MovieDomainInteractorImpl(private var movieRepoInteractor: MovieRepo) :
    MovieDomainInteractor {

    //Load movies
    override suspend fun loadMovies(): List<MovieDomainModel>? {
        return movieRepoInteractor.loadMovies()
    }

    //Load movie detail
    override suspend fun loadMovieDetail(iD: String): MovieDetailDomainModel? {
        return movieRepoInteractor.loadMovieDetail(iD)
    }
}