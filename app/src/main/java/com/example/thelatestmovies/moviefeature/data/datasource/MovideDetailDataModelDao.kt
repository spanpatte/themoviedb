package com.example.thelatestmovies.moviefeature.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.domain.models.MovieDetailDomainModel

@Dao
interface MovieDetailDataModelDao {
    @Query("SELECT * FROM MovieDetailDataModel WHERE id = :id")
    fun get(id: Int): MovieDetailDataModel

    @Insert
    fun save(movie: MovieDetailDataModel?)
}