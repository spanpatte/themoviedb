package com.spanpatte.thelatestmovies.moviefeature.domain.interactors

import com.spanpatte.thelatestmovies.moviefeature.data.models.toMovieDetailDomainModel
import com.spanpatte.thelatestmovies.moviefeature.domain.repository.MovieRepo
import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDataModelToDomainModelMapper
import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel
import com.spanpatte.thelatestmovies.moviefeature.domain.models.MovieDomainModel
import javax.inject.Inject

//This class is a part of Domain layer and contain the business logic.
// Will operate on the data received from Repository layer as per the business use case
class MovieDomainInteractorImpl @Inject constructor(private  val movieRepo: MovieRepo):
    MovieDomainInteractor {

    //Load movies
    override suspend fun loadMovies(): List<MovieDomainModel>? {
        return movieRepo.loadMovies()?.let { MovieDataModelToDomainModelMapper.map(it) }
    }

    //Load movie detail
    override suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel? {
        return movieRepo.loadMovieDetail(id)?.toMovieDetailDomainModel()
    }
}