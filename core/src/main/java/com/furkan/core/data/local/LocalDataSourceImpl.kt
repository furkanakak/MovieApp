package com.furkan.core.data.local

import com.furkan.core.common.networking.BaseLocalDataSource
import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieDb
import com.furkan.core.domain.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private  val movieDao: MovieDao) : BaseLocalDataSource(),LocalDataSource {
    override suspend fun insertMovie(movie: MovieDb) {
        movieDao.insertMovie(movie)
    }
    override suspend fun getMoviesByPage(page: Int): Resource<List<MovieDb>> = getResult {
            movieDao.getMoviesByPage(page)
    }


}