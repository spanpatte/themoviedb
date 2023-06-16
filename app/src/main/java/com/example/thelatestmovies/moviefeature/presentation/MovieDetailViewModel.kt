package com.example.thelatestmovies.moviefeature.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailEntity
import com.example.thelatestmovies.moviefeature.data.models.toMovieDetailModel
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MovieDetailViewModel : ViewModel() {

    @Inject
    lateinit var movieUseCase: MovieDomainInteractor

    val exception = MutableLiveData<Exception>()

    val movieDetail = MutableLiveData<MovieDetailModel>()

    fun loadMovieDetail(iD: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                movieUseCase.loadMovieDetail(iD)?.let { setMovieDetail(map(it)) }
            } catch (ex:Exception){
                exception.postValue(ex)
            }


        }
    }
    private fun map(movieDetailDao: MovieDetailEntity): MovieDetailModel {
        return movieDetailDao.toMovieDetailModel()
    }
    fun setMovieDetail(newData: MovieDetailModel) {
        movieDetail.value = newData
    }

    fun getMovieDetail(): MovieDetailModel? {
        return movieDetail.value
    }


}






