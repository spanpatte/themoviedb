package com.example.thelatestmovies.moviefeature.presentation.views


import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.thelatestmovies.moviefeature.dagger.DaggerMovieFeatureComponent
import com.example.thelatestmovies.moviefeature.dagger.MovieModule
import com.example.thelatestmovies.moviefeature.data.models.StubData
import com.example.thelatestmovies.moviefeature.presentation.viewmodels.MovieDetailViewModel
import com.example.thelatestmovies.moviefeature.presentation.models.MovieDetailModel
import com.example.thelatestmovies.moviefeature.presentation.viewmodels.MovieListViewModel


class MovieDetailActivity : AppCompatActivity() {
    private val movieDetailViewModel: MovieDetailViewModel by lazy {

        ViewModelProvider(
            this,
            MovieDetailViewModel.Factory(this.application)
        )[MovieDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Inject model in Dagger
        DaggerMovieFeatureComponent.builder().movieModule(MovieModule(this)).build()
            .inject(movieDetailViewModel)


        //Which movie detail to be shown
        val id = intent.getIntExtra("movieId", 0)


        id.let {

            movieDetailViewModel.loadMovieDetail(it)

        }

        setContent {
            //Show in case of exception
            ErrorMessage()
            //Live data
            val movieDetail = movieDetailViewModel.movieDetail.observeAsState()

            //Load movie detail with available data and update once Live data is available
            MovieDetailCard(movieDetail.value)
        }

    }


    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun MovieDetailCard(movieDetail: MovieDetailModel?) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            if (movieDetail != null) {

                //Use of Glide to display image
                GlideImage(
                    model = movieDetail.poster_path,
                    contentDescription = "",
                    modifier =
                    Modifier
                        .background(color = Color.White)
                )
                Text(text = movieDetail.original_title)
                Text(text = movieDetail.tagline)
                Text(text = movieDetail.release_date)
                Text(text = movieDetail.overview)
                Text(text = movieDetail.status)

            }

        }


    }

    @Composable
    fun ErrorMessage() {
        if (movieDetailViewModel.exception.value) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    text = "Something went wrong. Movie Detail could not be retrieved",
                    modifier = Modifier
                )

            }
        }

    }


    //Example to see preview
    @Preview
    @Composable
    fun MovieDetail() {
        MovieDetailCard(movieDetail = StubData.movieDetail)
    }
}