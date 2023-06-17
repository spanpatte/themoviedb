package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
//Interface for interacting with repo
interface MovieRepo {

    suspend fun loadMovies(): List<MovieDomainModel>?

    suspend fun loadMovieDetail(id: Int): MovieDetailDomainModel?


}