package com.spanpatte.thelatestmovies.moviefeature.data.apis


import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModelResponse
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import retrofit2.Response

import retrofit2.http.Path
import retrofit2.http.Query

//Call for Movie list API
interface MovieApiInterface {
    suspend fun getMovies(@Query("api_key") apiKey: String): Response<MovieDataModelResponse>
    suspend fun getMovieDetail(@Path("id") movieId: Int, @Query("api_key") apiKey: String ): Response<MovieDetailDataModel>
}