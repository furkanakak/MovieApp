package com.furkan.core.data.remote

import com.furkan.core.common.networking.Resource
import com.furkan.core.common.networking.performNetworkOperationFlow
import com.furkan.core.data.entity.MovieResponse
import com.furkan.core.domain.RemoteDataSource
import com.furkan.core.domain.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun getMovies(page: Int): Flow<Resource<MovieResponse>> = performNetworkOperationFlow {
            remoteDataSource.getMovies(page)
        }

}