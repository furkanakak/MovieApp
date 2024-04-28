package com.furkan.movieapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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


    fun getMovies(page: Int) {
        viewModelScope.launch {
            repository.getMovies(page).collect { resource ->
                _movies.value = resource
            }
        }

    }
}