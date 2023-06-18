package com.spanpatte.thelatestmovies.moviefeature.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel

@Dao
interface MovieDetailDataModelDao {
    @Query("SELECT * FROM MovieDetailDataModel WHERE id = :id")
    fun get(id: Int): MovieDetailDataModel

    @Insert
    fun save(movie: MovieDetailDataModel?)
}