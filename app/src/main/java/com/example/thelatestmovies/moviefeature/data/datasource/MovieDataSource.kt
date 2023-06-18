package com.example.thelatestmovies.moviefeature.data.datasource

import android.content.Context
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel

interface MovieDataSource {
    suspend fun getMovies(): List<MovieDataModel>?
    suspend fun saveMovies(movies: List<MovieDataModel>)
    suspend fun getMovieDetail(id: Int): MovieDetailDataModel?
    suspend fun saveMovieDetail(movie: MovieDetailDataModel?)
}