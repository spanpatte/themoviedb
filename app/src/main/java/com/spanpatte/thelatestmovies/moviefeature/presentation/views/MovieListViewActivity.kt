package com.spanpatte.thelatestmovies.moviefeature.presentation.views


import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.spanpatte.thelatestmovies.moviefeature.dagger.DaggerMovieFeatureComponent
import com.spanpatte.thelatestmovies.moviefeature.dagger.MovieModule
import com.spanpatte.thelatestmovies.moviefeature.presentation.viewmodels.MovieListViewModel
import com.spanpatte.thelatestmovies.moviefeature.presentation.models.MovieModel


class MovieListViewActivity : AppCompatActivity() {

    private val movieListViewModel: MovieListViewModel by lazy{

        ViewModelProvider(
            this,
            MovieListViewModel.Factory(this.application)
        )[MovieListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Inject model in Dagger
        //DaggerMovieFeatureComponent.builder().movieModule(MovieModule(this)).build().inject(movieListViewModel)
        val builder: DaggerMovieFeatureComponent.Builder =  DaggerMovieFeatureComponent.builder()
        builder.movieModule(MovieModule(this))
        builder.build().inject(movieListViewModel)

        //DaggerMovieFeatureComponent.builder().build().inject(movieListViewModel)


        //Initial call to load movies
        movieListViewModel.loadMovies()


        setContent {

            ProgressBar()
            RetryMessage()

            //Observe live data
            val movies = movieListViewModel.movies.observeAsState()
            //Load the screen without movies, will be updated once movies are retrieved
            MovieList(movies)
        }

    }
    private fun handleMovieSelection(id: Int) {

        val intent = Intent(applicationContext, MovieDetailActivity::class.java)
        intent.putExtra("movieId", id)
        startActivity(intent)
    }

    @Composable
    fun ProgressBar(){
        if(movieListViewModel.loading.value){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {

                CircularProgressIndicator()
            }

        }
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
    Row() {
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

    @Composable
    fun RetryMessage() {
        if(movieListViewModel.exception.value){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "Something went wrong. Movies cond not be retrieved",
                modifier = Modifier
            )
            Button(
                onClick = {
                       retryToLoadMovies()
                },
                modifier = Modifier.padding(all = Dp(10F)),
                enabled = true,
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
                shape = MaterialTheme.shapes.medium
            )
            {
                Text(text = "Refresh", color = Color.White)
            }
        }
        }

    }
    private fun retryToLoadMovies(){
        movieListViewModel.loadMovies()
    }

}




