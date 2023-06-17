package com.example.thelatestmovies.moviefeature.presentation


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.domain.toMovieModel
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import com.example.thelatestmovies.moviefeature.domain.MovieDomainModelToModelMapper
import kotlinx.coroutines.*
import javax.inject.Inject


class MovieListViewModel : ViewModel() {

    @Inject
    lateinit var movieDomainInteractor: MovieDomainInteractor

    val movies = MutableLiveData<List<MovieModel>>()
    //val _movies = movies
    val exception = MutableLiveData<Exception>()

    //Load movies
    fun loadMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            withContext(context = this.coroutineContext) {
                try {
                    val moviesData = movieDomainInteractor.loadMovies()
                    Log.d("MyTag", Thread.currentThread().name)
                    movies.postValue(moviesData?.let { MovieDomainModelToModelMapper.map(it) })
                } catch (ex: Exception) {
                    exception.postValue(ex)
                }
            }

        }

    }



}






