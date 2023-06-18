package com.example.thelatestmovies.moviefeature.data.repositories

import android.util.Log
import com.example.thelatestmovies.moviefeature.data.datasource.MovieDatabaseDataSource
import com.example.thelatestmovies.moviefeature.data.datasource.MovieRemoteDataSource
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.toMovieDetailDomainModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel
import javax.inject.Inject

//Implementation for Movie repo
class MovieRepoImpl @Inject constructor(
    private val movieRemoveDataSource: MovieRemoteDataSource,
    private val movieDatabaseDataSource: MovieDatabaseDataSource
) : MovieRepo {


    override suspend fun loadMovies(): List<MovieDataModel>? {

        try {
            val moviesDataModel = movieRemoveDataSource.getMovies()
            if (moviesDataModel != null) {
                movieDatabaseDataSource.saveMovies(moviesDataModel)
            }
        } catch (ex: Exception) {
            Log.d("MyTag", ex.toString())
        }

        return movieDatabaseDataSource.getMovies()


    }

    override suspend fun loadMovieDetail(id: Int): MovieDetailDataModel? {
        try {
            var movieDetailDataModel = movieRemoveDataSource.getMovieDetail(id)
            movieDatabaseDataSource.saveMovieDetail(movieDetailDataModel)
        } catch (ex: Exception){
            Log.d("MyTag",ex.toString())
        }
        var movieDetail = movieDatabaseDataSource.getMovieDetail(id)

        return movieDetail
    }

}