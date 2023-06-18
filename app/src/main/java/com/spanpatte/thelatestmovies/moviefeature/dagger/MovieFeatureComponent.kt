package com.spanpatte.thelatestmovies.moviefeature.dagger

import com.spanpatte.thelatestmovies.moviefeature.presentation.viewmodels.MovieDetailViewModel
import com.spanpatte.thelatestmovies.moviefeature.presentation.viewmodels.MovieListViewModel
import common.dagger.NetworkModule
import dagger.Component
import javax.inject.Singleton

//This is the Dagger component for the Movie feature
@Singleton
@Component(modules = [MovieModule::class, NetworkModule::class])
interface MovieFeatureComponent {
    fun inject(viewModel: MovieListViewModel)
    fun inject(viewModel: MovieDetailViewModel)
}