package com.furkan.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.furkan.core.data.entity.MovieDb


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDb)

    @Query("SELECT * FROM MovieDb WHERE page = :page ORDER BY `index` ASC")
    fun getMoviesByPage(page: Int): List<MovieDb>



}