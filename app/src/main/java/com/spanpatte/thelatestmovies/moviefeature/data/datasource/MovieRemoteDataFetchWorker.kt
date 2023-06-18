package com.spanpatte.thelatestmovies.moviefeature.data.datasource

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class MovieRemoteDataFetchWorker(appContext: Context,
                                 params: WorkerParameters,
                                 private val movieRemoveDataSource: MovieRemoteDataSource,
                                 private val movieDatabaseDataSource: MovieDatabaseDataSource
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        return try {
            val moviesDataModel = movieRemoveDataSource.getMovies()
            if (moviesDataModel != null) {
                movieDatabaseDataSource.saveMovies(moviesDataModel)
            }
            //val outputData = blurAndWriteImageToFile(resourceUri)
            Result.success()
        } catch (throwable: Throwable) {
            //Timber.e(throwable, "Error applying blur")
            Result.failure()
        }
    }
}