package com.example.thelatestmovies.moviefeature.data.repositories

import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDomainModel

//Interface for interacting with repo
interface MovieRepo {
    suspend fun loadMovies(): List<MovieDataModel>?
    suspend fun loadMovieDetail(id: Int): MovieDetailDataModel?
}