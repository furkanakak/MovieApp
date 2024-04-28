package com.furkan.core.domain

import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovies(page: Int) : Flow<Resource<MovieResponse>>
}