package com.example.thelatestmovies.moviefeature.dagger


import com.example.thelatestmovies.moviefeature.data.datasource.MovieDataSource
import com.example.thelatestmovies.moviefeature.data.datasource.MovieDataSourceImpl
import com.example.thelatestmovies.moviefeature.domain.MovieRepoImpl
import com.example.thelatestmovies.moviefeature.domain.MovieRepo
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractorImpl
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
//Dagger module to manage the dependency for Movie feature
@Module
class MovieModule {
    @Provides
    fun provideMovieUseCase(movieRepo: MovieRepo): MovieDomainInteractor {
        return MovieDomainInteractorImpl(movieRepo)
    }


    @Provides
    fun provideMovieDataSource(retrofit: Retrofit): MovieDataSource {
        return MovieDataSourceImpl(retrofit)
    }

    @Provides
    fun provideMovieRepo(dataSource: MovieDataSource): MovieRepo {
        return MovieRepoImpl(dataSource)
    }


}