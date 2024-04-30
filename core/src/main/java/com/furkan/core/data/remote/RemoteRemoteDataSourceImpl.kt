package com.furkan.core.data.remote


import com.furkan.core.common.Constants
import com.furkan.core.common.networking.BaseRemoteDataSource
import com.furkan.core.domain.RemoteDataSource
import javax.inject.Inject

class RemoteRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : BaseRemoteDataSource(), RemoteDataSource{
    override suspend fun getMovies(page: Int) = getResult {
        apiService.getMovies(Constants.API_KEY, page)
    }

}




