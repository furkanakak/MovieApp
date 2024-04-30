package com.furkan.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MovieDb")
data class MovieDb(
    @ColumnInfo(name ="adult")
    var adult: Boolean? = null,
    @ColumnInfo(name ="backDropPath")
    var backDropPath: String? = null,
    @ColumnInfo(name ="genreIds")
    var genreIds: List<Int>? = null,
    @PrimaryKey
    @ColumnInfo(name ="id")
    var id: Int,
    @ColumnInfo(name ="originalLanguage")
    var originalLanguage: String? = null,
    @ColumnInfo(name ="originalTitle")
    var originalTitle: String? = null,
    @ColumnInfo(name ="overView")
    var overView: String? = null,
    @ColumnInfo(name ="popularity")
    var popularity: Double? = null,
    @ColumnInfo(name ="posterPath")
    var posterPath: String? = null,
    @ColumnInfo(name ="releaseDate")
    var releaseDate: String? = null,
    @ColumnInfo(name ="title")
    var title: String? = null,
    @ColumnInfo(name ="video")
    var video: Boolean? = null,
    @ColumnInfo(name ="voteAverage")
    var voteAverage: Double? = null,
    @ColumnInfo(name ="voteCount")
    var voteCount: Int? = null,
    @ColumnInfo(name ="page")
    var page : Int? = null,
    @ColumnInfo(name ="index")
    var index : Int? = null
)