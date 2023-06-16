package com.example.thelatestmovies.moviefeature.data.apis


import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
import retrofit2.Response
import retrofit2.http.GET

//Call for Movie detail API
interface MovieDetailApi {
    @GET("/movie")
    suspend fun getMovieDetail(): Response<MovieDetailEntity>
}
