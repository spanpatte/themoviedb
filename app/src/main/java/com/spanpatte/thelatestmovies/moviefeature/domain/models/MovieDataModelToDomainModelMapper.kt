package com.spanpatte.thelatestmovies.moviefeature.domain.models

import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.domain.toMovieDomainModel

class MovieDataModelToDomainModelMapper {
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