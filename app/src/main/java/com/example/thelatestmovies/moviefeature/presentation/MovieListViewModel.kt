package com.example.thelatestmovies.moviefeature.presentation


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import kotlinx.coroutines.*
import javax.inject.Inject


class MovieListViewModel : ViewModel() {

    @Inject
    lateinit var movieDomainInteractor: MovieDomainInteractor

    val movies = MutableLiveData<List<MovieModel>>()

    var exception = mutableStateOf(false)
    var loading = mutableStateOf(false)

    //Load movies
    fun loadMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            loading.value = true
            exception.value = false

            withContext(context = this.coroutineContext) {
                try {
                    val moviesData = movieDomainInteractor.loadMovies()
                    Log.d("THREAD", Thread.currentThread().name)
                    movies.postValue(moviesData?.let { MovieDomainModelToModelMapper.map(it) })
                } catch (ex: Exception) {
                    exception.value = true
                } finally {
                    loading.value = false
                }

            }

        }

    }



}






