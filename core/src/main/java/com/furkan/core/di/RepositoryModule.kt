package com.furkan.core.di

import com.furkan.core.data.local.LocalDataSourceImpl
import com.furkan.core.data.local.MovieDao
import com.furkan.core.data.remote.ApiService
import com.furkan.core.data.remote.RemoteRemoteDataSourceImpl
import com.furkan.core.data.remote.RepositoryImpl
import com.furkan.core.domain.LocalDataSource
import com.furkan.core.domain.RemoteDataSource
import com.furkan.core.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource,localDataSource: LocalDataSource): Repository {
        return RepositoryImpl(remoteDataSource,localDataSource)
    }

    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): LocalDataSource {
        return LocalDataSourceImpl(movieDao)
    }

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteRemoteDataSourceImpl(apiService)
    }

}