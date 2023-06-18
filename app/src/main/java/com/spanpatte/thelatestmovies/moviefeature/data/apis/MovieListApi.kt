package com.spanpatte.thelatestmovies.moviefeature.data.apis


import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModelResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

//Call for Movie list API
interface MovieListApi : MovieApiInterface{
    @GET("/3/movie/popular")
    override suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieDataModelResponse>
}
