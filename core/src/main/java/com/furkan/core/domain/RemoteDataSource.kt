package com.furkan.core.domain

import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieResponse


interface RemoteDataSource {
    suspend fun getMovies(page: Int): Resource<MovieResponse>
}