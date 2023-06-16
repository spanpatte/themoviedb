package com.example.thelatestmovies.moviefeature.dagger


import com.example.thelatestmovies.moviefeature.data.repos.MovieRepoImpl
import com.example.thelatestmovies.moviefeature.data.repos.MovieRepoInteractor
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractorImpl
import com.example.thelatestmovies.moviefeature.domain.MovieDomainInteractor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
//Dagger module to manage the dependency for Movie feature
@Module
class MovieModule {
    @Provides
    fun provideMovieUseCase(movieRepo: MovieRepoInteractor): MovieDomainInteractor {
        return MovieDomainInteractorImpl(movieRepo)
    }

    @Provides
    fun provideMovieRepo(retrofit: Retrofit): MovieRepoInteractor {
        return MovieRepoImpl(retrofit)
    }

}