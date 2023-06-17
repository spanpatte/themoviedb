package com.example.thelatestmovies.moviefeature.domain

import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel

class MovieDataModelToDomainModelMapper()  {
    companion object Mapper{
        fun map(inputList: List<MovieDataModel>):List<MovieDomainModel>  {
            val outputList  = ArrayList<MovieDomainModel>()
            inputList.forEach {
                outputList.add(it.toMovieDomainModel())
            }
            return outputList
        }
    }

}