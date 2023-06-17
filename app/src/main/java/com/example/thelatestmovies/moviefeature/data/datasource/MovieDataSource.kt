package com.example.thelatestmovies.moviefeature.data.datasource

import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel

interface MovieDataSource {
    suspend fun getMovies(): List<MovieDataModel>?
    suspend fun getMovieDetail(): MovieDetailDataModel?
}