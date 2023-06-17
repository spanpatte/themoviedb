package com.example.thelatestmovies.moviefeature.presentation


import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.thelatestmovies.moviefeature.dagger.DaggerMovieFeatureComponent
import com.example.thelatestmovies.moviefeature.data.StubData



class MovieDetailActivity : AppCompatActivity() {
    private val viewModel: MovieDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inject movie detail model in Dagger
        DaggerMovieFeatureComponent.builder().build().inject(viewModel)

        //Which movie detail to be shown
        val iD = intent.getStringExtra("movieId")


        iD?.let {

            viewModel.loadMovieDetail(it)
            viewModel.exception.observe(this){
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }

        setContent {
            //Live data
            val movieDetail = viewModel.movieDetail.observeAsState()

            //Load movie detail with available data and update once Live data is available
            MovieDetailCard(movieDetail.value)
        }

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
                    .background(color = Color.Blue)

            )
            Text(
                text = movieDetail.original_title,

                )
            Text(
                text = movieDetail.release_date,

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