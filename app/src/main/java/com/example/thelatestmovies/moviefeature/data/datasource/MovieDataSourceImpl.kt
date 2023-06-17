package com.example.thelatestmovies.moviefeature.data.datasource

import com.example.thelatestmovies.moviefeature.Configs
import com.example.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.example.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import retrofit2.Retrofit
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : MovieDataSource{
    override suspend fun getMovies(): List<MovieDataModel>? {
        val api: MovieListApi = retrofit.create(MovieListApi::class.java)
        val results = api.getMovies(Configs.apiKey).body()?.results
        return results
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailDataModel? {
        val api: MovieDetailApi = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail(id,Configs.apiKey)
        return result.body()
    }
}