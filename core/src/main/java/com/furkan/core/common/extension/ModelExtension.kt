package com.furkan.core.common.extension

import com.furkan.core.data.entity.Movie
import com.furkan.core.data.entity.MovieDb

/**
 * Converts a Movie object to a MovieDb object with optional page and index parameters.
 * @param page Optional page number where the movie is listed (default is null).
 * @param index Optional index of the movie on the page (default is null).
 * @return Returns a new MovieDb object containing the same data as the Movie object.
 * @throws IllegalArgumentException if the Movie object does not have an ID.
 */
fun Movie.toMovieDb(page: Int? = null, index: Int? = null): MovieDb {
    return MovieDb(
        adult = this.adult,
        backDropPath = this.backDropPath,
        genreIds = this.genreIds,
        id = this.id ?: throw IllegalArgumentException("ID is required for MovieDb"),
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overView = this.overView,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount,
        page = page,
        index = index
    )
}
/**
 * Converts a MovieDb object back into a Movie object.
 * @return Returns a new Movie object with the same data as the MovieDb object.
 */
fun MovieDb.toMovie(): Movie {
    return Movie(
        adult = this.adult,
        backDropPath = this.backDropPath,
        genreIds = this.genreIds,
        id = this.id,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overView = this.overView,
        popularity = this.popularity,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount
    )
}

/**
 * Converts a List of MovieDb objects into a List of Movie objects.
 * @return Returns a new list of Movie objects converted from the list of MovieDb objects.
 */
fun List<MovieDb>.toMovieList(): List<Movie> {
    return this.map { movieDb ->
        movieDb.toMovie()
    }
}