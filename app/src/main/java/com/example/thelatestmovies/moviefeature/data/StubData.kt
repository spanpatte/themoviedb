package com.example.thelatestmovies.moviefeature.data

import com.example.thelatestmovies.moviefeature.presentation.MovieDetailModel
import com.example.thelatestmovies.moviefeature.presentation.MovieModel


/**
 * SampleData for Jetpack Compose Tutorial
 */
object StubData {
    // Sample conversation data
    val movies = listOf(
        MovieModel(
            Id = "1",
            Title = "Chiu2",
            Poster = "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg",

        ),
        MovieModel(
            Id = "2",
            Title = "Sattu",
            Poster = "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg",

        )
    )
    val movieDetail =
        MovieDetailModel(
            Id = "1",
            Title = "Chiu2",
            Poster = "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg",
            Runtime = "This is 3 star movie",
            Year = "This is 3 star movie"
        )


}
