package com.furkan.core.domain

import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieDb

interface LocalDataSource {
   suspend fun insertMovie(movie: MovieDb)
   suspend fun getMoviesByPage(page: Int) : Resource<List<MovieDb>>

}