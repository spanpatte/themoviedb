package com.spanpatte.thelatestmovies.moviefeature.data.datasource


import android.util.Log
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieApiInterface
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import retrofit2.Retrofit
import javax.inject.Inject

object DataConfigs {
    const val movieApiBaseUrl = "https://api.themoviedb.org"
    const val apiKey = "9abede7c9e83c0d9c4b68b3559bb09d9"
}
class MovieRemoteDataSource @Inject constructor(private val retrofit: Retrofit) : MovieDataSource{
    override suspend fun getMovies(): List<MovieDataModel>? {
        val api: MovieApiInterface = retrofit.create(MovieListApi::class.java)
        val results = api.getMovies(DataConfigs.apiKey).body()?.results
        return results
    }

    override suspend fun saveMovies(movies: List<MovieDataModel>) {
        Log.d("MyTag", "No need to upload movies to server")
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailDataModel? {
        val api: MovieApiInterface = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail(id,DataConfigs.apiKey)
        return result.body()
    }

    override suspend fun saveMovieDetail(movie: MovieDetailDataModel?) {
        Log.d("MyTag", "No need to upload movie detail to server")
    }


}