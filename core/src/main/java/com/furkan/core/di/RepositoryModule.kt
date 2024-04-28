package com.furkan.core.di

import com.furkan.core.data.remote.ApiService
import com.furkan.core.data.remote.RemoteDataSourceImpl
import com.furkan.core.data.remote.RepositoryImpl
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
    fun provideRepository(repository : RepositoryImpl): Repository {
        return repository
    }

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

}