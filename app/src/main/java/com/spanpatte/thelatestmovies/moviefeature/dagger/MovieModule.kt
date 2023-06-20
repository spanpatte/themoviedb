package com.spanpatte.thelatestmovies.moviefeature.dagger

import android.content.Context
import com.spanpatte.thelatestmovies.moviefeature.data.datasource.*
import com.spanpatte.thelatestmovies.moviefeature.domain.repository.MovieRepo
import com.spanpatte.thelatestmovies.moviefeature.data.repositories.MovieRepoImpl
import com.spanpatte.thelatestmovies.moviefeature.domain.interactors.MovieDomainInteractor
import com.spanpatte.thelatestmovies.moviefeature.domain.interactors.MovieDomainInteractorImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

//Dagger module to manage the dependency for Movie feature
@Module
class MovieModule (private val context: Context){
    @Provides
    fun provideMovieUseCase(movieRepo: MovieRepo): MovieDomainInteractor {
        return MovieDomainInteractorImpl(movieRepo)
    }

    @Provides
    fun provideMovieRemoteDataSource(retrofit: Retrofit): MovieRemoteDataSource {
        return MovieRemoteDataSource(retrofit)
    }

    @Provides
    fun provideMovieDatabaseDataSource(): MovieDatabaseDataSource {
        return MovieDatabaseDataSource(context)
    }

    @Provides
    fun provideMovieRepo(movieRemoveDataSource: MovieRemoteDataSource,movieDatabaseDataSource: MovieDatabaseDataSource): MovieRepo {
        return MovieRepoImpl(movieRemoveDataSource,movieDatabaseDataSource)
    }

    @Provides
    fun provideMovieDatabaseDao(): MovieDataModelDao {
        return MovieDB.getInstance(context).movieDataModelDao()
    }
    @Provides
    fun provideMovieDetailDatabaseDao(): MovieDetailDataModelDao {
        return MovieDB.getInstance(context).movieDetailDataModelDao()
    }

}