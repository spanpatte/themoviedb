package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.datasource.MovieDataSource
import com.example.thelatestmovies.moviefeature.data.models.*
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

//Implementation for Movie repo
@Singleton
class MovieRepoImpl @Inject constructor(private val movieDataSource: MovieDataSource) : MovieRepo {
    override suspend fun loadMovies(): List<MovieDomainModel>? {
        val moviesDataModel = movieDataSource.getMovies()
        return moviesDataModel?.let { MovieDataModelToDomainModelMapper.map(it) }
    }
    override suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel? {
        return movieDataSource.getMovieDetail(id)?.toMovieDetailDomainModel()
    }
}