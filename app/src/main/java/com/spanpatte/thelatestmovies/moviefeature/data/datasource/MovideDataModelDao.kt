package com.spanpatte.thelatestmovies.moviefeature.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel

@Dao
interface MovieDataModelDao {
    @Query("SELECT * FROM MovieDataModel LIMIT 0,10")
    fun getAll(): List<MovieDataModel>

    @Insert
    fun insertAll(movies: List<MovieDataModel>)

}