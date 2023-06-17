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
            id = 1,
            original_title = "Chiu2",
            poster_path = "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg",

        ),
        MovieModel(
            id = 2,
            original_title = "Sattu",
            poster_path = "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg",

        )
    )
    val movieDetail =
        MovieDetailModel(

                id = 9485,
                original_title = "Fast X",
                original_language= "en",
                overview= "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted, out-nerved and outdriven every foe in their path. Now, they confront the most lethal opponent they've ever faced: A terrifying threat emerging from the shadows of the past who's fueled by blood revenge, and who is determined to shatter this family and destroy everything—and everyone—that Dom loves, forever.",
                popularity= 10063.212,
                poster_path= "/fiVW06jE7z9YnO4trhaMEdclSiC.jpg",
                release_date="2023-05-17",
                vote_count= 1597,
                tagline= "The end of the road begins.",
                status= "Released",
            )


}
