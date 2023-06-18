package com.example.thelatestmovies.moviefeature.presentation.models

import com.example.thelatestmovies.moviefeature.domain.models.MovieDomainModel
import com.example.thelatestmovies.moviefeature.domain.toMovieModel

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


