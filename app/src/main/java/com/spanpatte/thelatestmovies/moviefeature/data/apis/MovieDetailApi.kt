package com.spanpatte.thelatestmovies.moviefeature.data.apis


import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Call for Movie detail API
interface MovieDetailApi : MovieApiInterface{
    @GET("/3/movie/{id}")
    override suspend fun getMovieDetail(@Path("id") movieId: Int, @Query("api_key") apiKey: String ): Response<MovieDetailDataModel>
}
