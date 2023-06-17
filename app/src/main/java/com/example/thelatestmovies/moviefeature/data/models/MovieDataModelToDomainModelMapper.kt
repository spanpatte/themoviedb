package com.example.thelatestmovies.moviefeature.data.models

import com.example.thelatestmovies.moviefeature.domain.MovieDomainModel

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