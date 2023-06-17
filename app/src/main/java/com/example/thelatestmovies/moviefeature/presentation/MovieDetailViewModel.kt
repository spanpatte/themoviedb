package com.example.thelatestmovies.moviefeature.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import com.example.thelatestmovies.moviefeature.domain.MovieDomainModelToModelMapper
import com.example.thelatestmovies.moviefeature.domain.toMovieDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MovieDetailViewModel : ViewModel() {

    @Inject
    lateinit var movieUseCase: MovieDomainInteractor

    val exception = MutableLiveData<Exception>()

    val movieDetail = MutableLiveData<MovieDetailModel>()

    fun loadMovieDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                movieUseCase.loadMovieDetail(id)?.let { setMovieDetail(it.toMovieDetailModel()) }
            } catch (ex:Exception){
                exception.postValue(ex)
            }
        }
    }

    fun setMovieDetail(newData: MovieDetailModel) {
        movieDetail.postValue(newData)
    }




}






