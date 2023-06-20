package com.spanpatte.thelatestmovies.moviefeature.domain.repository

import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel

//Interface for interacting with repo
interface MovieRepo {
    suspend fun loadMovies(): List<MovieDataModel>?
    suspend fun loadMovieDetail(id: Int): MovieDetailDataModel?
}