package com.example.thelatestmovies.moviefeature.data.apis


import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import retrofit2.Response

import retrofit2.http.GET

//Call for Movie list API
interface MovieListApi {
    @GET("/3/movie/popular?api_key=9abede7c9e83c0d9c4b68b3559bb09d9")
    suspend fun getMovies(): Response<List<MovieDataModel>>
}
