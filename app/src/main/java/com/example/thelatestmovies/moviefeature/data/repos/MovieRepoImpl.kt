package com.example.thelatestmovies.moviefeature.data.repos

import com.example.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.example.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
import com.example.thelatestmovies.moviefeature.data.models.MovieEntity
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

//Implementation for Movie repo
@Singleton
class MovieRepoImpl @Inject constructor(private val retrofit: Retrofit) : MovieRepoInteractor {

    override suspend fun loadMovies(): List<MovieEntity>? {
        val api: MovieListApi = retrofit.create(MovieListApi::class.java)
        val result = api.getMovies()
        return result.body()
    }

    override suspend fun loadMovieDetail(iD: String): MovieDetailEntity? {

        val api: MovieDetailApi = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail()
        return result.body()
    }

}