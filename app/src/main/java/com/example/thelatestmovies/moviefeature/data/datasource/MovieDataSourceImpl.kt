package com.example.thelatestmovies.moviefeature.data.datasource

import com.example.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.example.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import retrofit2.Retrofit
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : MovieDataSource{
    override suspend fun getMovies(): List<MovieDataModel>? {
        val api: MovieListApi = retrofit.create(MovieListApi::class.java)
        val result = api.getMovies()
        return result.body()
    }

    override suspend fun getMovieDetail(): MovieDetailDataModel? {
        val api: MovieDetailApi = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail()
        return result.body()
    }
}