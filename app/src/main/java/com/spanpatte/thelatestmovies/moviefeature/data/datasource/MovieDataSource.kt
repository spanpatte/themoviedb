package com.spanpatte.thelatestmovies.moviefeature.data.datasource

import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel

interface MovieDataSource {
    suspend fun getMovies(): List<MovieDataModel>?
    suspend fun saveMovies(movies: List<MovieDataModel>)
    suspend fun getMovieDetail(id: Int): MovieDetailDataModel?
    suspend fun saveMovieDetail(movie: MovieDetailDataModel?)
}