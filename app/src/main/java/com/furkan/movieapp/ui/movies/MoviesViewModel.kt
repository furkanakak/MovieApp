package com.furkan.movieapp.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.core.common.extension.log
import com.furkan.core.common.extension.toMovieDb
import com.furkan.core.common.extension.toMovieList
import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.MovieResponse
import com.furkan.core.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _movies = MutableStateFlow<Resource<MovieResponse>>(Resource.loading(null))
    val movies: StateFlow<Resource<MovieResponse>> = _movies.asStateFlow()
    private var page: MutableStateFlow<Int> = MutableStateFlow(1)
    var isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var isNetworkAvailable: Boolean? = null

    fun getMovies() {
        if (page.value < 6) {
            if (isNetworkAvailable == true) {
                remoteMovies()
            }
            if (isNetworkAvailable == false) {
                localMovies()
            }
        }

    }

    private fun localMovies() {
        viewModelScope.launch {
            repository.getMoviesByPage(page.value).collect { resource ->
                if (resource.status == Resource.Status.SUCCESS){
                    "MoviesFragment" log "localMovies -> page: ${page.value}"
                    _movies.value = Resource.success(
                        MovieResponse( movies = resource.data?.toMovieList() ?: emptyList())
                    )
                    page.value++
                }
            }
        }

    }

    private fun remoteMovies() {
        viewModelScope.launch {
            repository.getMovies(page.value).collect { resource ->
                if (resource.status == Resource.Status.SUCCESS) {
                    insertMovies(resource.data, page.value)
                    page.value++
                }
                _movies.value = resource
            }
        }
    }

    private fun insertMovies(data: MovieResponse?, page: Int) {
        viewModelScope.launch {
            data?.movies?.forEachIndexed { index, it ->
                val movie = it.toMovieDb(page, index)
                repository.insertMovie(movie)
            }
        }
    }


}