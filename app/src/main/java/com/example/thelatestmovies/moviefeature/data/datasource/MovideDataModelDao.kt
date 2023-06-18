package com.example.thelatestmovies.moviefeature.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel

@Dao
interface MovieDataModelDao {
    @Query("SELECT * FROM MovieDataModel")
    fun getAll(): List<MovieDataModel>

    @Insert
    fun insertAll(movies: List<MovieDataModel>)

}