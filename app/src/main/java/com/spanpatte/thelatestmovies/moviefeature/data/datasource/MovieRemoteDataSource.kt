package com.spanpatte.thelatestmovies.moviefeature.data.datasource


import android.util.Log
import com.spanpatte.thelatestmovies.BuildConfig
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieApiInterface
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieDetailApi
import com.spanpatte.thelatestmovies.moviefeature.data.apis.MovieListApi
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDataModel
import com.spanpatte.thelatestmovies.moviefeature.data.models.MovieDetailDataModel
import retrofit2.Retrofit
import javax.inject.Inject


class MovieRemoteDataSource @Inject constructor(private val retrofit: Retrofit) : MovieDataSource{
    override suspend fun getMovies(): List<MovieDataModel>? {
        val api: MovieApiInterface = retrofit.create(MovieListApi::class.java)
        val results = api.getMovies(BuildConfig.TMDB_API_KEY).body()?.results
        return results
    }

    override suspend fun saveMovies(movies: List<MovieDataModel>) {
        Log.d("MyTag", "No need to upload movies to server")
    }

    override suspend fun getMovieDetail(id: Int): MovieDetailDataModel? {
        val api: MovieApiInterface = retrofit.create(MovieDetailApi::class.java)
        val result = api.getMovieDetail(id,BuildConfig.TMDB_API_KEY)
        return result.body()
    }

    override suspend fun saveMovieDetail(movie: MovieDetailDataModel?) {
        Log.d("MyTag", "No need to upload movie detail to server")
    }


}