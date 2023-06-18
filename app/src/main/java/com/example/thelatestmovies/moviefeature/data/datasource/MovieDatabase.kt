package com.example.thelatestmovies.moviefeature.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel

@Database(entities = [MovieDataModel::class, MovieDetailDataModel::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDataModelDao(): MovieDataModelDao
    abstract fun movieDetailDataModelDao(): MovieDetailDataModelDao
}
