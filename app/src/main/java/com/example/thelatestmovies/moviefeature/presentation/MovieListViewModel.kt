package com.example.thelatestmovies.moviefeature.presentation


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thelatestmovies.moviefeature.data.models.MovieEntity
import com.example.thelatestmovies.moviefeature.data.models.toMovieModel
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
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
                val value = try {
                    var moviesData = movieDomainInteractor.loadMovies()
                    Log.d("MyTag", Thread.currentThread().name)
                    movies.postValue(moviesData?.let { map(it) })
                } catch (ex: Exception) {
                    exception.postValue(ex)
                }
            }

        }

    }


    //Map the dao to model. View may not need all the fields and Model should not be exposed to View
    private fun map(movieDaolList: List<MovieEntity>): List<MovieModel> {
        val modelList = ArrayList<MovieModel>()
        for (dao in movieDaolList) {
            val model = dao.toMovieModel()
            modelList.add(model)
        }
        return modelList
    }
}






