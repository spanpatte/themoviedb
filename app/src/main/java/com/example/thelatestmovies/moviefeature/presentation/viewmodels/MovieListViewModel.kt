package com.example.thelatestmovies.moviefeature.presentation.viewmodels


import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.thelatestmovies.moviefeature.domain.interactors.MovieDomainInteractor
import com.example.thelatestmovies.moviefeature.presentation.models.MovieDomainModelToModelMapper
import com.example.thelatestmovies.moviefeature.presentation.models.MovieModel
import kotlinx.coroutines.*
import javax.inject.Inject

class MovieListViewModel(private var context: Application) : AndroidViewModel(context) {

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
                    Log.d("THREAD", ex.toString())
                    exception.value = true
                } finally {
                    loading.value = false
                }

            }

        }

    }


    //Factory for constructing MovieListViewModel with parameter

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}






