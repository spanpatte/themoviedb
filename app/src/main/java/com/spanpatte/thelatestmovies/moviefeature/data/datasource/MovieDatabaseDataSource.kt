package com.spanpatte.thelatestmovies.moviefeature.data.datasource

import android.content.Context
import androidx.room.Room
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel

class MovieDatabaseDataSource(private val context: Context) : MovieDataSource {

    override suspend fun getMovies(): List<MovieDataModel> {
        val database = MovieDB.getInstance(context)
        val movieDataModelDao = database.movieDataModelDao()
        return movieDataModelDao.getAll()
    }
    override suspend fun saveMovies(movies:List<MovieDataModel>){
        val database = MovieDB.getInstance(context)
        val movieDataModelDao = database.movieDataModelDao()
        movieDataModelDao.insertAll(movies)
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailDataModel {
        val database = MovieDB.getInstance(context)
        val movieDetailDataModelDao = database.movieDetailDataModelDao()
        return movieDetailDataModelDao.get(id)
    }
    override suspend fun saveMovieDetail(movie: MovieDetailDataModel?){
        val database = MovieDB.getInstance(context)
        val movieDetailDataModelDao = database.movieDetailDataModelDao()
        return movieDetailDataModelDao.save(movie)
    }
}
object MovieDB{
    fun getInstance(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "database-name"
        ).build()
    }
}
