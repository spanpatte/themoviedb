package com.example.thelatestmovies.moviefeature.presentation.viewmodels


import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.thelatestmovies.moviefeature.domain.interactors.MovieDomainInteractor
import com.example.thelatestmovies.moviefeature.domain.toMovieDetailModel
import com.example.thelatestmovies.moviefeature.presentation.models.MovieDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MovieDetailViewModel(private var context: Application) :  AndroidViewModel(context) {

    @Inject
    lateinit var movieUseCase: MovieDomainInteractor

    val exception = mutableStateOf(false)

    val movieDetail = MutableLiveData<MovieDetailModel>()

    fun loadMovieDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                var model = movieUseCase.loadMovieDetail(id)
                if (model == null)
                    exception.value = true
                else
                    setMovieDetail(model.toMovieDetailModel())
            } catch (ex: Exception) {
                exception.value = true
            }
        }
    }

    private fun setMovieDetail(newData: MovieDetailModel) {
        movieDetail.postValue(newData)
    }

    //Factory for constructing MovieListViewModel with parameter

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieDetailViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}






