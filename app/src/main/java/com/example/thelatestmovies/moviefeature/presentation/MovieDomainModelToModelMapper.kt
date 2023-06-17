package com.example.thelatestmovies.moviefeature.presentation

import com.example.thelatestmovies.moviefeature.domain.MovieDomainModel
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


