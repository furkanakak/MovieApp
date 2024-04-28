package com.furkan.core.data.remote


import com.furkan.core.common.Constants
import com.furkan.core.common.networking.BaseDataSource
import com.furkan.core.domain.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : BaseDataSource(), RemoteDataSource{
    override suspend fun getMovies(page: Int) = getResult {
        apiService.getMovies(Constants.API_KEY, page)
    }

}




