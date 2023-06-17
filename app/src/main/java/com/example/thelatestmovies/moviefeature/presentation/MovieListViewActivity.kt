package com.example.thelatestmovies.moviefeature.presentation


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer


import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.thelatestmovies.moviefeature.dagger.DaggerMovieFeatureComponent

class MovieListViewActivity : AppCompatActivity() {
    private val movieListViewModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Inject model in Dagger
        DaggerMovieFeatureComponent.builder().build().inject(movieListViewModel)

        //Initial call to load movies
        movieListViewModel.loadMovies()
        //Check for exception
        movieListViewModel.exception.observe(this){
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }

        setContent {
            //Observe live data
            val movies = movieListViewModel.movies.observeAsState()
            //Load the screen without movies, will be updated once movies are retrieved
            MovieList(movies)
        }


    }

    private fun handleMovieSelection(iD: Int) {

        val intent = Intent(applicationContext, MovieDetailActivity::class.java)
        intent.putExtra("movieId", iD)
        startActivity(intent)
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun MovieCard(movie: MovieModel) {
        GlideImage(
            model = movie.poster_path,
            contentDescription = "image",
            modifier =
            Modifier
                .fillMaxSize()
                .clickable {
                    handleMovieSelection(movie.id)
                }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = movie.original_title,
                modifier = Modifier

            )

        }


    }


    @Composable
    fun MovieList(movies: State<List<MovieModel>?>) {

        //Lazy load the movie list.
        LazyColumn {
            movies.value?.forEach { movie ->
                item() {
                    //Add movie cards/items
                    MovieCard(movie)
                }
            }
        }
    }

}




