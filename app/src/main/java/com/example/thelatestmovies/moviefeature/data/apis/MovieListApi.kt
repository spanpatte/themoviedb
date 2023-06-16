package com.example.thelatestmovies.moviefeature.data.apis


import com.example.thelatestmovies.moviefeature.data.models.MovieEntity
import retrofit2.Response

import retrofit2.http.GET

//Call for Movie list API
interface MovieListApi {
    @GET("/movies")
    suspend fun getMovies(): Response<List<MovieEntity>>
}
