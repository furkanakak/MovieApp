package com.furkan.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.furkan.core.data.entity.MovieDb

@TypeConverters(Converters::class)
@Database(entities = [MovieDb::class], version = 1, exportSchema = false)

abstract class MovieDatabase  : RoomDatabase() {
    abstract fun itemDao(): MovieDao
}