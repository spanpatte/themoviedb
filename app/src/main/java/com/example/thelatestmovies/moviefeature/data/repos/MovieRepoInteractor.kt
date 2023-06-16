package com.example.thelatestmovies.moviefeature.data.repos

import com.example.thelatestmovies.moviefeature.data.models.MovieEntity
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
//Interface for interacting with repo
interface MovieRepoInteractor {

    suspend fun loadMovies(): List<MovieEntity>?

    suspend fun loadMovieDetail(iD: String): MovieDetailEntity?


}