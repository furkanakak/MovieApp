package com.furkan.core.domain

import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieDb
import com.furkan.core.data.entity.MovieResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovies(page: Int) : Flow<Resource<MovieResponse>>
    suspend fun insertMovie(movie : MovieDb)
    suspend fun getMoviesByPage(page: Int) : Flow<Resource<List<MovieDb>>>

}