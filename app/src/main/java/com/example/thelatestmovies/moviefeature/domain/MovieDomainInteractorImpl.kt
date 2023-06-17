package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import javax.inject.Inject


class MovieDomainInteractorImpl@Inject constructor(private  val movieRepo: MovieRepo):
    MovieDomainInteractor {

    //Load movies
    override suspend fun loadMovies(): List<MovieDomainModel>? {
        return movieRepo.loadMovies()
    }

    //Load movie detail
    override suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel? {
        return movieRepo.loadMovieDetail(id)
    }
}