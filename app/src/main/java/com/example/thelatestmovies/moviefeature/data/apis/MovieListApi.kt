package com.example.thelatestmovies.moviefeature.data.apis


import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

//Call for Movie list API
interface MovieListApi {
//    @GET("/3/movie/popular")
//    suspend fun getMovies(@Query("apiKey") apiKey: String): Response<List<MovieDataModel>>

    @GET("/movies")
    suspend fun getMovies(): Response<List<MovieDataModel>>
}
