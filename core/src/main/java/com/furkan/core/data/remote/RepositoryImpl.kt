package com.furkan.core.data.remote

import com.furkan.core.common.networking.Resource
import com.furkan.core.common.networking.performNetworkOperationFlow
import com.furkan.core.data.entity.MovieDb
import com.furkan.core.data.entity.MovieResponse
import com.furkan.core.domain.LocalDataSource
import com.furkan.core.domain.RemoteDataSource
import com.furkan.core.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun getMovies(page: Int): Flow<Resource<MovieResponse>> =
        performNetworkOperationFlow {
            remoteDataSource.getMovies(page)
        }

    override suspend fun insertMovie(movie : MovieDb){
        return localDataSource.insertMovie(movie)
    }

    override suspend fun getMoviesByPage(page: Int): Flow<Resource<List<MovieDb>>> =
        performNetworkOperationFlow {
             localDataSource.getMoviesByPage(page)
        }

}