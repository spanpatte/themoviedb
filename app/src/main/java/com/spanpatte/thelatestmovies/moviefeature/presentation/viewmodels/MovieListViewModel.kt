package com.spanpatte.thelatestmovies.moviefeature.presentation.viewmodels


import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.spanpatte.thelatestmovies.moviefeature.domain.interactors.MovieDomainInteractor
import com.spanpatte.thelatestmovies.moviefeature.presentation.models.MovieDomainModelToModelMapper
import com.spanpatte.thelatestmovies.moviefeature.presentation.models.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListViewModel(context: Application) : AndroidViewModel(context) {

        @Inject
    lateinit var movieDomainInteractor: MovieDomainInteractor

    private val _movies = MutableLiveData<List<MovieModel>>()
    val movies
    get() = _movies

    private val _exception = mutableStateOf(false)
    val exception
    get() = _exception

    private val _loading = mutableStateOf(false)
    val loading
        get() = _loading

    //Load movies
    fun loadMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            loading.value = true
            exception.value = false

            withContext(context = this.coroutineContext) {
                try {
                    Log.d("THREAD", Thread.currentThread().name)
                    val moviesData = movieDomainInteractor.loadMovies()
                    if(moviesData == null || moviesData.isEmpty())
                        exception.value = true
                    else
                        movies.postValue(MovieDomainModelToModelMapper.map(moviesData) )
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






