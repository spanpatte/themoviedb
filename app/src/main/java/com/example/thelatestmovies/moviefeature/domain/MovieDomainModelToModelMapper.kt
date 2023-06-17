package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.example.thelatestmovies.moviefeature.data.models.toMovieDomainModel
import com.example.thelatestmovies.moviefeature.presentation.MovieModel

class MovieDomainModelToModelMapper{
    companion object Mapper {
        fun map(inputList: List<MovieDomainModel>): List<MovieModel> {
            val outputList  = ArrayList<MovieModel>()
            inputList.forEach {
                outputList.add(it.toMovieModel())
            }
            return outputList
        }
    }

}


