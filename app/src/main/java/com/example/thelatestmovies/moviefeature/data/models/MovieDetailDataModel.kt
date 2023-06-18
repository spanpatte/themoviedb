package com.example.thelatestmovies.moviefeature.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class
MovieDetailDataModel(
    @PrimaryKey val id: Int,
    val original_title: String,
    val original_language: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val vote_count: Int,
    val tagline: String,
    val status: String)
