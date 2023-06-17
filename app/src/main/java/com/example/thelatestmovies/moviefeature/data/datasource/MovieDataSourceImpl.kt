package com.example.thelatestmovies.moviefeature.data.datasource


import com.example.thelatestmovies.moviefeature.data.apis.MovieApiInterface
import com.example.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.example.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.example.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import com.example.thelatestmovies.moviefeature.data.models.MovieDataModel
import retrofit2.Retrofit
import javax.inject.Inject
object DataConfigs {
    const val movieApiBaseUrl = "https://api.themoviedb.org"
    const val apiKey = "9abede7c9e83c0d9c4b68b3559bb09d9"
}
class MovieDataSourceImpl @Inject constructor(private val retrofit: Retrofit) : MovieDataSource{
    override suspend fun getMovies(): List<MovieDataModel>? {
        val api: MovieApiInterface = retrofit.create(MovieListApi::class.java)
        val results = api.getMovies(DataConfigs.apiKey).body()?.results
        return results
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailDataModel? {
        val api: MovieApiInterface = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail(id,DataConfigs.apiKey)
        return result.body()
    }
}