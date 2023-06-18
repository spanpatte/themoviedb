package com.example.thelatestmovies.moviefeature.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


data class MovieDataModelResponse(
    val page: Int,
    val results: List<MovieDataModel>
)
@Entity
data class MovieDataModel(
    @PrimaryKey val id: Int,
    val original_title: String,
    val poster_path: String
)
