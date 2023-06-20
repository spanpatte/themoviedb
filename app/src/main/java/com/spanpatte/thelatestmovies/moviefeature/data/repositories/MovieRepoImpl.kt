package com.spanpatte.thelatestmovies.moviefeature.data.repositories

import android.util.Log
import com.spanpatte.thelatestmovies.moviefeature.data.datasource.MovieDatabaseDataSource
import com.spanpatte.thelatestmovies.moviefeature.data.datasource.MovieRemoteDataSource
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.spanpatte.thelatestmovies.moviefeature.domain.repository.MovieRepo
import javax.inject.Inject

//Implementation for Movie repo
class MovieRepoImpl @Inject constructor(
    private val movieRemoveDataSource: MovieRemoteDataSource,
    private val movieDatabaseDataSource: MovieDatabaseDataSource
) : MovieRepo {


    override suspend fun loadMovies(): List<MovieDataModel> {

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

    override suspend fun loadMovieDetail(id: Int): MovieDetailDataModel {
        try {
            val movieDetailDataModel = movieRemoveDataSource.getMovieDetail(id)
            movieDatabaseDataSource.saveMovieDetail(movieDetailDataModel)
        } catch (ex: Exception) {
            Log.d("MyTag", ex.toString())
        }

        return movieDatabaseDataSource.getMovieDetail(id)
    }

}