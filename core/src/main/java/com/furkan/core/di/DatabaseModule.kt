package com.furkan.core.di

import android.content.Context
import androidx.room.Room
import com.furkan.core.data.local.MovieDao
import com.furkan.core.data.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): MovieDatabase {
        return Room
            .databaseBuilder(context, MovieDatabase::class.java, "Database.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideItemDao(roomDB: MovieDatabase): MovieDao {
        return roomDB.itemDao()
    }







}